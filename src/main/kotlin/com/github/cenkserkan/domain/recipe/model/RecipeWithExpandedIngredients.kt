package com.github.cenkserkan.domain.recipe.model

data class RecipeWithExpandedIngredients(val recipe: Recipe, val recipeIngredients: List<ExpandedRecipeIngredient>)
