package com.github.cenkserkan.domain.recipe.port

import com.github.cenkserkan.domain.recipe.model.Recipe
import java.util.UUID

interface RecipePort {

    fun findRecipesByIngredients(ids: List<UUID>): List<Recipe>
}
