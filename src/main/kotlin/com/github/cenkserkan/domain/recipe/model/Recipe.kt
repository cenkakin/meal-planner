package com.github.cenkserkan.domain.recipe.model

import java.util.UUID

data class Recipe(
    val id: UUID,
    val title: String,
    val instructions: List<String>,
    val recipeIngredients: List<RecipeIngredient>,
    val recipeImages: List<String>?,
) {

    companion object {
        fun from(basicRecipe: BasicRecipe, instructions: List<String>, recipeIngredients: List<RecipeIngredient>): Recipe {
            return Recipe(basicRecipe.id, basicRecipe.title, instructions, recipeIngredients, basicRecipe.recipeImages)
        }
    }
}
