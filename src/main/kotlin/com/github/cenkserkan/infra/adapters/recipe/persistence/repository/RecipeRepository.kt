package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.recipe.model.BasicRecipe
import com.github.cenkserkan.domain.recipe.model.FSALights
import com.github.cenkserkan.infra.adapters.generated.Tables.RECIPE
import com.github.cenkserkan.infra.adapters.generated.Tables.RECIPE_IMAGE
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeImageRecord
import org.jooq.DSLContext
import org.jooq.Record6
import java.util.UUID

class RecipeRepository(private val dslContext: DSLContext) {

    fun findByIds(recipeIds: List<UUID>): List<BasicRecipe> {
        val imagesByRecipeId = getImagesByRecipeIds(recipeIds)
        return dslContext.select(
            RECIPE.ID,
            RECIPE.TITLE,
            RECIPE.FSA_FAT,
            RECIPE.FSA_SUGAR,
            RECIPE.FSA_SATURATED,
            RECIPE.FSA_SALT
        )
            .from(RECIPE)
            .where(RECIPE.ID.`in`(recipeIds))
            .fetch()
            .map { it.toBasicRecipe(imagesByRecipeId[it.component1()]) }
    }

    private fun getImagesByRecipeIds(recipeIds: List<UUID>) = dslContext.selectFrom(RECIPE_IMAGE)
        .where(RECIPE_IMAGE.RECIPE_ID.`in`(recipeIds))
        .fetch()
        .groupBy { it.recipeId }

    fun getBasicRecipeById(id: UUID): BasicRecipe? {
        val recipeImages = recipeImagesByRecipeId(id)
        return dslContext.select(
            RECIPE.ID,
            RECIPE.TITLE,
            RECIPE.FSA_FAT,
            RECIPE.FSA_SUGAR,
            RECIPE.FSA_SATURATED,
            RECIPE.FSA_SALT
        )
            .from(RECIPE)
            .where(RECIPE.ID.eq(id))
            .fetchOne()
            ?.toBasicRecipe(recipeImages)
    }

    fun getInstructionsByRecipeId(id: UUID): List<String> {
        return dslContext
            .select(
                RECIPE.INSTRUCTIONS
            )
            .from(RECIPE)
            .where(RECIPE.ID.eq(id))
            .fetch()
            .flatMap {
                it.component1().toList()
            }
    }

    private fun recipeImagesByRecipeId(id: UUID) = dslContext.selectFrom(RECIPE_IMAGE)
        .where(RECIPE_IMAGE.RECIPE_ID.eq(id))
        .fetch()

    private fun Record6<UUID, String, String, String, String, String>.toBasicRecipe(recipeImageRecords: List<RecipeImageRecord>?) =
        BasicRecipe(
            id = this.component1(),
            title = this.component2(),
            fsaLights = FSALights(
                fsaFat = this.component3(),
                fsaSugar = this.component4(),
                fsaSaturated = this.component5(),
                fsaSalt = this.component6()
            ),
            recipeImages = recipeImageRecords?.sortedBy { it.priority }?.map { it.url }
        )
}
