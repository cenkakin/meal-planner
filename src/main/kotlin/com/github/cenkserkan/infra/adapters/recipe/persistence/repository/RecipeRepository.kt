package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.recipe.model.BasicRecipe
import com.github.cenkserkan.infra.adapters.generated.Tables.RECIPE
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeRecord
import org.jooq.DSLContext
import java.util.UUID

class RecipeRepository(private val dslContext: DSLContext) {
    fun findByIds(recipeIds: List<UUID>): List<BasicRecipe> {
        return dslContext.selectFrom(RECIPE)
            .where(RECIPE.ID.`in`(recipeIds))
            .fetch()
            .map { it.toRecipe() }
    }

    fun getById(id: UUID): BasicRecipe? {
        return dslContext.selectFrom(RECIPE)
            .where(RECIPE.ID.eq(id))
            .fetchOne()
            ?.toRecipe()
    }
}

private fun RecipeRecord.toRecipe() = BasicRecipe(id, name, cuisine)
