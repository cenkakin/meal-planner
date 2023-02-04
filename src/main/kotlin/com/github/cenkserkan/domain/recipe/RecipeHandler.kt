package com.github.cenkserkan.domain.recipe

import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.domain.recipe.usecase.RecipeSearchUseCase
import java.util.UUID

class RecipeHandler(private val recipePort: RecipePort) :
    RecipeSearchUseCase {

    override fun getByIngredients(ids: List<UUID>): List<Recipe> {
        return recipePort.findRecipesByIngredients(ids)
    }
}
