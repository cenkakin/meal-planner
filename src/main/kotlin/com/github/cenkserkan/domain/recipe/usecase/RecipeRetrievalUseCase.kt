package com.github.cenkserkan.domain.recipe.usecase

import com.github.cenkserkan.domain.recipe.model.RecipeWithExpandedIngredients
import java.util.UUID

interface RecipeRetrievalUseCase {

    fun getRecipeWithIngredientsById(id: UUID): RecipeWithExpandedIngredients
}
