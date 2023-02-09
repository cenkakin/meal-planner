package com.github.cenkserkan.domain.aggregateRecipe.model

import com.github.cenkserkan.domain.ingredient.model.Ingredient
import com.github.cenkserkan.domain.recipe.model.Recipe
import java.util.UUID

data class AggregateRecipe(val recipe: Recipe, val ingredients: List<RecipeIngredient>)