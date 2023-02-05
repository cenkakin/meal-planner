package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.infra.adapters.generated.Tables.RECIPE
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeRecord
import org.jooq.DSLContext
import java.util.UUID

class RecipeRepository(private val dslContext: DSLContext) {
    fun findByIds(recipeIds: List<UUID>): List<Recipe> {
        return dslContext.selectFrom(RECIPE)
            .where(RECIPE.ID.`in`(recipeIds))
            .fetch()
            .map { it.toRecipe() }
    }
}

private fun RecipeRecord.toRecipe() = Recipe(id, name, cuisine)
