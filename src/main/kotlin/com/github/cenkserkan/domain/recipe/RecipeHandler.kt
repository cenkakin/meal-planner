package com.github.cenkserkan.domain.recipe

import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.domain.recipe.model.RecipeCreateCommand
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.domain.recipe.usecase.RecipeCreateUseCase
import com.github.cenkserkan.domain.recipe.usecase.RecipeGetUseCase

class RecipeHandler(private val recipePort: RecipePort) : RecipeGetUseCase, RecipeCreateUseCase {

    override fun getRecipe(id: String): Recipe {
        TODO("Not yet implemented")
    }

    override fun createRecipe(recipeCreateCommand: RecipeCreateCommand): Recipe {
        TODO("Not yet implemented")
    }
}
