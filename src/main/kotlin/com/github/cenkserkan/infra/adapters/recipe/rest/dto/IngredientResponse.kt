package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.Ingredient
import java.util.UUID

data class IngredientResponse(val id: UUID, val name: String, val unit: String, val weight: Int) {
    companion object {
        fun from(ingredient: Ingredient): IngredientResponse {
            return with(ingredient) {
                IngredientResponse(id, name, unit, weight)
            }
        }
    }
}
