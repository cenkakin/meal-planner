package com.github.cenkserkan.infra.adapters.aggregateRecipe.persistence.repository

import com.github.cenkserkan.domain.aggregateRecipe.model.RecipeIngredient
import com.github.cenkserkan.infra.adapters.generated.Tables.INGREDIENT
import com.github.cenkserkan.infra.adapters.generated.Tables.RECIPE_INGREDIENT
import com.github.cenkserkan.infra.adapters.generated.tables.Recipe.RECIPE
import org.jooq.DSLContext
import org.jooq.Records
import org.jooq.impl.DSL.multiset
import org.jooq.impl.DSL.select
import java.util.UUID

class AggregateRecipeRepository(val dslContext: DSLContext) {
    //TODO: Return AggregateRecipe
    //  To map from jooq records to AggregateRecipe:
    //  Option1: Create a jooq custom table/records
    //  Option2: Create a db view or table for aggregated recipe and have jooq generate its records
    //  Option3: Explore jooq's fetch into or fetch mappings
    fun findById(id: UUID) {
        dslContext.select(RECIPE.ID,
            RECIPE.NAME,
            RECIPE.CUISINE,
            multiset(
                select(INGREDIENT.ID, INGREDIENT.NAME, INGREDIENT.UNIT, INGREDIENT.WEIGHT, RECIPE_INGREDIENT.AMOUNT)
                    .from(RECIPE_INGREDIENT)
                    .leftJoin(INGREDIENT)
                    .on(RECIPE_INGREDIENT.INGREDIENT_ID.eq(INGREDIENT.ID))
                    .where(RECIPE_INGREDIENT.RECIPE_ID.eq(RECIPE.ID))
            ).`as`("ingredients").convertFrom { r -> r.map(Records.mapping{

            }) }
        ).from(RECIPE)
            .leftJoin(RECIPE_INGREDIENT)
            .on(RECIPE.ID.eq(RECIPE_INGREDIENT.RECIPE_ID))
            .leftJoin(INGREDIENT)
            .on(RECIPE_INGREDIENT.INGREDIENT_ID.eq(INGREDIENT.ID))
            .where(RECIPE.ID.eq(id))
            .fetch()
    }
}