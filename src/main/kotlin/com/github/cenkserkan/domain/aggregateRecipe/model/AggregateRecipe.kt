package com.github.cenkserkan.domain.aggregateRecipe.model

import com.github.cenkserkan.domain.ingredient.model.Ingredient
import java.util.UUID

data class AggregateRecipe(val id: UUID, val name: String, val cuisine: String, val ingredients: List<RecipeIngredient>)