package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.RecipeWithExpandedIngredients

data class ExpandedRecipeResponse(val recipe: RecipeResponse, val recipeIngredients: List<RecipeIngredientResponse>) {

    companion object {
        fun from(recipeWithExpandedIngredients: RecipeWithExpandedIngredients): ExpandedRecipeResponse {
            val recipe = RecipeResponse.from(recipeWithExpandedIngredients.recipe)
            val recipeIngredients = recipeWithExpandedIngredients.recipeIngredients.map {
                RecipeIngredientResponse.from(it)
            }
            return ExpandedRecipeResponse(recipe, recipeIngredients)
        }
    }
}
