package com.github.cenkserkan.domain.recipe.model

import java.util.UUID

data class Recipe(val id: UUID, val name: String, val recipeIngredients: List<RecipeIngredient>) {

    companion object {
        fun from(basicRecipe: BasicRecipe, recipeIngredients: List<RecipeIngredient>): Recipe {
            return Recipe(basicRecipe.id, basicRecipe.title, recipeIngredients)
        }
    }
}
