package com.github.cenkserkan.infra.adapters.recipe.persistence

import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeRepository

class RecipeDataAdapter(private val recipeRepository: RecipeRepository) : RecipePort {

    override fun createRecipe(recipe: Recipe) {
        TODO("Not yet implemented")
    }

    override fun getRecipe(id: String) {
        TODO("Not yet implemented")
    }
}
