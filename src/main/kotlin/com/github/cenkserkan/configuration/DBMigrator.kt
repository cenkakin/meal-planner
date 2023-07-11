package com.github.cenkserkan.configuration

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.cenkserkan.infra.adapters.generated.Tables
import com.github.cenkserkan.infra.adapters.generated.tables.Ingredient.INGREDIENT
import com.github.cenkserkan.infra.adapters.generated.tables.Recipe.RECIPE
import com.github.cenkserkan.infra.adapters.generated.tables.records.IngredientRecord
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeImageRecord
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeIngredientRecord
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeRecord
import jakarta.annotation.PostConstruct
import org.jooq.DSLContext
import org.springframework.core.io.ClassPathResource
import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger

// @Component
class DBMigrator(private val dslContext: DSLContext) {

    private val recipesWithDuplicateItemsCount = AtomicInteger()

    private val processedIngredients = mutableMapOf<String, UUID>()
    private val recipeExtIdToRecipeRecordId = mutableMapOf<String, UUID>()

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
            val recipeId = createRecipe(jsRecipe)
            recipeExtIdToRecipeRecordId[jsRecipe.id] = recipeId

            val recipeIngredientRecords = jsRecipe.ingredients.mapIndexed { i, ingredient ->
                val nutritionPerIngredient = jsRecipe.nutrPerIngredient[i]
                val weightPerIngr = jsRecipe.weightPerIngr[i]
                val quantity = jsRecipe.quantity[i]
                val unit = jsRecipe.unit[i].text
                val ingredientId = ingredient.text.createOrGetIngredient(nutritionPerIngredient, weightPerIngr)
                recipeIngredientRecord(recipeId, ingredientId, weightPerIngr, quantity, unit)
            }
            val distinctRecipeIngredients = recipeIngredientRecords.distinctBy { "${it.ingredientId}${it.recipeId}" }
            if (distinctRecipeIngredients.size != recipeIngredientRecords.size) {
                recipesWithDuplicateItemsCount.incrementAndGet()
                println("Recipe contains an ingredient more than once. Saving anyway. recipeId=$recipeId, jsRecipeId=${jsRecipe.id}")
                println("recipesWithDuplicateItemsCount = $recipesWithDuplicateItemsCount")
            }
            dslContext.batchInsert(recipeIngredientRecords).execute()
        }

        recipeImageParser.processItems(JSImage::class.java) {
            val recipeId = recipeExtIdToRecipeRecordId[it.id] ?: return@processItems
            val distinctImageUrls = it.images.map { image -> image.url }.distinct()
            val imageRecords = distinctImageUrls.mapIndexed { index, imageUrl ->
                RecipeImageRecord().apply {
                    this.recipeId = recipeId
                    this.priority = index + 1
                    this.url = imageUrl
                }
            }

            dslContext.batchInsert(imageRecords).execute()
        }
    }

    private fun recipeIngredientRecord(
        recipeId: UUID,
        ingredientId: UUID?,
        weightPerIngr: Double,
        quantity: JSText,
        unit: String
    ): RecipeIngredientRecord {
        return RecipeIngredientRecord().apply {
            this.recipeId = recipeId
            this.ingredientId = ingredientId
            this.weightInGram = weightPerIngr
            this.quantity = quantity.text
            this.unit = unit
        }
    }

    private fun createRecipe(jsRecipe: JSRecipe): UUID {
        val recipeRecord = RecipeRecord().apply {
            this.title = jsRecipe.title
            this.url = jsRecipe.url
            this.fsaFat = jsRecipe.fsaLightsPer100g.fat
            this.fsaSalt = jsRecipe.fsaLightsPer100g.salt
            this.fsaSaturated = jsRecipe.fsaLightsPer100g.saturates
            this.fsaSugar = jsRecipe.fsaLightsPer100g.sugars
            this.instructions = jsRecipe.instructions.map { it.text }.toTypedArray()
            this.energy = jsRecipe.nutrValuesPer100g.energy
            this.fat = jsRecipe.nutrValuesPer100g.fat
            this.protein = jsRecipe.nutrValuesPer100g.protein
            this.salt = jsRecipe.nutrValuesPer100g.salt
            this.saturatedFat = jsRecipe.nutrValuesPer100g.saturates
            this.sugar = jsRecipe.nutrValuesPer100g.sugars
        }

        return dslContext.insertInto(Tables.RECIPE).set(recipeRecord).returningResult(RECIPE.ID).fetchOne()!!
            .component1()
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
        val weightPerIngr: List<Double>
    )

    data class JSText(val text: String)

    data class FsaLights(val fat: String, val salt: String, val saturates: String, val sugars: String)

    data class NutritionPerIngredient(
        val fat: Double,
        val nrg: Double,
        val pro: Double,
        val sat: Double,
        val sod: Double,
        val sug: Double
    )

    data class NutritionPer100(
        val energy: Double,
        val fat: Double,
        val protein: Double,
        val salt: Double,
        val saturates: Double,
        val sugars: Double
    )

    data class JSImage(val id: String, val images: List<Image>)

    data class Image(val id: String, val url: String)

    private fun String.createOrGetIngredient(
        nutritionPerIngredient: NutritionPerIngredient,
        weightPerIngr: Double
    ): UUID? {
        val ingredientWithTags = this.split(", ")
        val name = if (ingredientWithTags.contains("pepper") && ingredientWithTags.size > 2) {
            ingredientWithTags.take(3).joinToString(", ")
        } else {
            ingredientWithTags.take(2).joinToString(", ")
        }

        if (processedIngredients.containsKey(name)) {
            return processedIngredients[name]
        }

        val ingredientRecord = IngredientRecord().apply {
            this.name = name
            tags = ingredientWithTags.drop(2).takeIf { it.isNotEmpty() }?.toTypedArray()
            salt = (nutritionPerIngredient.sod / weightPerIngr) * 100
            sugar = (nutritionPerIngredient.sug / weightPerIngr) * 100
            protein = (nutritionPerIngredient.pro / weightPerIngr) * 100
            energy = (nutritionPerIngredient.nrg / weightPerIngr) * 100
            fat = (nutritionPerIngredient.fat / weightPerIngr) * 100
            saturatedFat = (nutritionPerIngredient.sat / weightPerIngr) * 100
        }

        val ingredientId =
            dslContext.insertInto(Tables.INGREDIENT).set(ingredientRecord).returningResult(INGREDIENT.ID).fetchOne()!!
                .component1()
        processedIngredients[name] = ingredientId
        return ingredientId
    }
}
