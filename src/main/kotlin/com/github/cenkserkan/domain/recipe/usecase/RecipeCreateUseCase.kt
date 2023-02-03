package com.github.cenkserkan.domain.recipe.usecase

import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.domain.recipe.model.RecipeCreateCommand

interface RecipeCreateUseCase {

    fun createRecipe(recipeCreateCommand: RecipeCreateCommand): Recipe
}
