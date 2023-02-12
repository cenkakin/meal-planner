package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.RecipeIngredient

data class RecipeIngredientResponse(val ingredient: IngredientResponse, val quantity: Int) {
    companion object {
        fun from(recipeIngredient: RecipeIngredient): RecipeIngredientResponse {
            val ingredientResponse = IngredientResponse.from(recipeIngredient.ingredient)
            return RecipeIngredientResponse(ingredientResponse, recipeIngredient.quantity)
        }
    }
}
