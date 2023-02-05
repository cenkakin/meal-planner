package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.infra.adapters.generated.Tables.RECIPE_INGREDIENT
import org.jooq.DSLContext
import org.jooq.impl.DSL.count
import java.util.UUID

class RecipeIngredientsRepository(private val dslContext: DSLContext) {

    fun findRecipeIdsByIngredients(ids: List<UUID>): List<UUID> {
        return dslContext.select(RECIPE_INGREDIENT.RECIPE_ID)
            .from(RECIPE_INGREDIENT)
            .where(RECIPE_INGREDIENT.INGREDIENT_ID.`in`(ids))
            .groupBy(RECIPE_INGREDIENT.RECIPE_ID)
            .having(count().eq(ids.size))
            .fetch()
            .map { it.component1() }
    }
}
