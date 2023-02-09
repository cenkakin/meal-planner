package com.github.cenkserkan.infra.adapters.aggregateRecipe.rest.dto

import com.github.cenkserkan.infra.adapters.recipe.rest.dto.RecipeResponse

class AggregateRecipeResponse(val recipe: RecipeResponse, val recipeIngredients: List<RecipeIngredientResponse>) {

}
