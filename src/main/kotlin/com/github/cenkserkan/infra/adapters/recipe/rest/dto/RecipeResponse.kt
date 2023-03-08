package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.Recipe
import java.util.UUID

data class RecipeResponse(
    val id: UUID,
    val name: String,
    val recipeIngredients: List<RecipeIngredientResponse>
) {

    companion object {
        fun from(recipe: Recipe): RecipeResponse {
            val recipeIngredients = recipe.recipeIngredients.map {
                RecipeIngredientResponse.from(it)
            }
            return RecipeResponse(recipe.id, recipe.title, recipeIngredients)
        }
    }
}
