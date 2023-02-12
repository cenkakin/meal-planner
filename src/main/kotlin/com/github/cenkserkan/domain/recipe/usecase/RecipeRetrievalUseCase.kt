package com.github.cenkserkan.domain.recipe.usecase

import com.github.cenkserkan.domain.recipe.model.Recipe
import java.util.UUID

interface RecipeRetrievalUseCase {

    fun getRecipeById(id: UUID): Recipe
}
