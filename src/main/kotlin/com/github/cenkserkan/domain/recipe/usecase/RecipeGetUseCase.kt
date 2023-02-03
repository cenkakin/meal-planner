package com.github.cenkserkan.domain.recipe.usecase

import com.github.cenkserkan.domain.recipe.model.Recipe

interface RecipeGetUseCase {

    fun getRecipe(id: String): Recipe
}
