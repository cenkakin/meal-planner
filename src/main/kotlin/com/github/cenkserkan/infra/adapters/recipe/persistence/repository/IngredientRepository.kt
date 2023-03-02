package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.recipe.model.Ingredient
import com.github.cenkserkan.infra.adapters.generated.Tables
import com.github.cenkserkan.infra.adapters.generated.tables.records.IngredientRecord
import org.jooq.DSLContext

class IngredientRepository(private val dslContext: DSLContext) {
    fun getIngredients(): List<Ingredient> {
        return dslContext.selectFrom(Tables.INGREDIENT)
            .map { it.toIngredient() }
    }
}

private fun IngredientRecord.toIngredient(): Ingredient {
    return Ingredient(id = id, name = name)
}
