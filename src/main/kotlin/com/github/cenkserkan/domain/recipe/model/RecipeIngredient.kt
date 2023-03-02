package com.github.cenkserkan.domain.recipe.model

import java.util.UUID

data class RecipeIngredient(val recipeId: UUID, val ingredient: Ingredient, val quantity: Int, val unit: String)
