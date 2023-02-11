package com.github.cenkserkan.domain.recipe.model

import com.github.cenkserkan.domain.ingredient.model.Ingredient
import java.util.UUID

data class ExpandedRecipeIngredient(val recipeId: UUID, val ingredient: Ingredient, val quantity: Int)
