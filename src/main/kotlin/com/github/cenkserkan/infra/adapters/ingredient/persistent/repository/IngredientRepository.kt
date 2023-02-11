package com.github.cenkserkan.infra.adapters.ingredient.persistent.repository

import com.github.cenkserkan.domain.ingredient.model.Ingredient
import com.github.cenkserkan.infra.adapters.generated.Tables
import com.github.cenkserkan.infra.adapters.generated.tables.records.IngredientRecord
import org.jooq.DSLContext
import java.util.UUID

class IngredientRepository(private val dslContext: DSLContext) {
    fun getByIds(ids: List<UUID>): MutableList<Ingredient> {
        return dslContext.selectFrom(Tables.INGREDIENT)
            .where(Tables.INGREDIENT.ID.`in`(ids))
            .fetch()
            .map { it.toIngredient() }
    }
}

private fun IngredientRecord.toIngredient() = Ingredient(
    id,
    name,
    unit,
    weight,
)
