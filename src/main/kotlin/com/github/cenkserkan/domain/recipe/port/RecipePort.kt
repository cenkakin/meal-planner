package com.github.cenkserkan.domain.recipe.port

import com.github.cenkserkan.domain.recipe.model.Recipe

interface RecipePort {

    fun createRecipe(recipe: Recipe)

    fun getRecipe(id: String)
}
