package com.github.cenkserkan.domain.aggregateRecipe.model

import com.github.cenkserkan.domain.ingredient.model.Ingredient

// TODO: change amount to quantity below
data class RecipeIngredient(val ingredient: Ingredient, val amount: Int)