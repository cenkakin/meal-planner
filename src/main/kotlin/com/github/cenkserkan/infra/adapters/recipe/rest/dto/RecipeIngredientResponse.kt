package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.ExpandedRecipeIngredient

data class RecipeIngredientResponse(val ingredient: IngredientResponse, val quantity: Int) {
    companion object {
        fun from(expandedRecipeIngredient: ExpandedRecipeIngredient): RecipeIngredientResponse {
            val ingredientResponse = IngredientResponse.from(expandedRecipeIngredient.ingredient)
            return RecipeIngredientResponse(ingredientResponse, expandedRecipeIngredient.quantity)
        }
    }
}
