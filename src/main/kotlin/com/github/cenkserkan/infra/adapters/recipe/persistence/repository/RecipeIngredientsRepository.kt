package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.recipe.model.Ingredient
import com.github.cenkserkan.domain.recipe.model.RecipeIngredient
import com.github.cenkserkan.infra.adapters.generated.Tables.INGREDIENT
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

    fun getRecipeIngredientsByRecipeId(id: UUID): List<RecipeIngredient> {
        return dslContext.select(
            RECIPE_INGREDIENT.RECIPE_ID,
            INGREDIENT.ID,
            INGREDIENT.NAME,
            RECIPE_INGREDIENT.QUANTITY,
            RECIPE_INGREDIENT.UNIT
        )
            .from(RECIPE_INGREDIENT)
            .join(INGREDIENT)
            .on(RECIPE_INGREDIENT.INGREDIENT_ID.eq(INGREDIENT.ID))
            .where(RECIPE_INGREDIENT.RECIPE_ID.eq(id))
            .fetch()
            .map {
                RecipeIngredient(
                    recipeId = it.component1(),
                    Ingredient(
                        id = it.component2(),
                        name = it.component3()
                    ),
                    quantity = it.component4(),
                    unit = it.component5()
                )
            }
    }
}
