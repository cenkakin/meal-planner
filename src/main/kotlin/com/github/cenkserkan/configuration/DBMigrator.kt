package com.github.cenkserkan.configuration

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.cenkserkan.infra.adapters.generated.Tables
import com.github.cenkserkan.infra.adapters.generated.tables.records.IngredientRecord
import jakarta.annotation.PostConstruct
import org.jooq.DSLContext
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

@Component
class DBMigrator(private val dslContext: DSLContext) {

    private val processedIngredients = mutableListOf<String>()

    private val objectMapper = jacksonObjectMapper()

    private val recipeParser = run {
        val recipesFile = ClassPathResource("recipes_ignored.json").file
        objectMapper.createParser(recipesFile)
    }

    private val recipeImageParser = run {
        val recipesImagesFile = ClassPathResource("recipe_images_ignored.json").file
        objectMapper.createParser(recipesImagesFile)
    }

    @PostConstruct
    fun migrate() {
        recipeParser.processItems(JSRecipe::class.java) { jsRecipe ->
            val ingredients = jsRecipe.ingredients
            ingredients.mapIndexed { i, ingredient ->
                val nutritionPerIngredient = jsRecipe.nutrPerIngredient[i]
                val weightPerIngr = jsRecipe.weightPerIngr[i]
                ingredient.text.processIngredient(nutritionPerIngredient, weightPerIngr)
            }
        }
//        recipeImageParser.processItems(JSImage::class.java) {}
    }

    private fun <T> JsonParser.processItems(type: Class<T>, block: (T) -> Unit) {
        nextToken()
        nextToken()
        while (true) {
            val item = readValueAs(type) ?: break
            block(item)
        }
    }

    data class JSRecipe(
        @JsonProperty("fsa_lights_per100g")
        val fsaLightsPer100g: FsaLights,
        val id: String,
        val ingredients: List<JSText>,
        val instructions: List<JSText>,
        @JsonProperty("nutr_per_ingredient")
        val nutrPerIngredient: List<NutritionPerIngredient>,
        @JsonProperty("nutr_values_per100g")
        val nutrValuesPer100g: NutritionPer100,
        val partition: String,
        val quantity: List<JSText>,
        val title: String,
        val unit: List<JSText>,
        val url: String,
        @JsonProperty("weight_per_ingr")
        val weightPerIngr: List<Double>,
    )

    data class JSText(val text: String)

    data class FsaLights(val fat: String, val salt: String, val saturates: String, val sugars: String)

    data class NutritionPerIngredient(
        val fat: Double,
        val nrg: Double,
        val pro: Double,
        val sat: Double,
        val sod: Double,
        val sug: Double,
    )

    data class NutritionPer100(
        val energy: Double,
        val fat: Double,
        val protein: Double,
        val salt: Double,
        val saturates: Double,
        val sugars: Double,
    )

    data class JSImage(val id: String, val images: List<Image>)

    data class Image(val id: String, val url: String)

    private fun String.processIngredient(
        nutritionPerIngredient: NutritionPerIngredient,
        weightPerIngr: Double,
    ) {
        val ingredientWithTags = this.split(", ")
        val name = ingredientWithTags[0]
        if (name in processedIngredients) {
            return
        }

        val ingredientRecord = IngredientRecord().apply {
            this.name = name
            tags = ingredientWithTags.reversed().dropLast(1).toTypedArray()
            salt = (nutritionPerIngredient.sod / weightPerIngr) * 100
            sugar = (nutritionPerIngredient.sug / weightPerIngr) * 100
            protein = (nutritionPerIngredient.pro / weightPerIngr) * 100
            energy = (nutritionPerIngredient.nrg / weightPerIngr) * 100
            fat = (nutritionPerIngredient.fat / weightPerIngr) * 100
            saturatedFat = (nutritionPerIngredient.sat / weightPerIngr) * 100
        }

        dslContext.insertInto(Tables.INGREDIENT).set(ingredientRecord).execute()
        processedIngredients.add(name)
    }
}
