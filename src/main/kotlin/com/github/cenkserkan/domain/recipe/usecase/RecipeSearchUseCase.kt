package com.github.cenkserkan.domain.recipe.usecase

import com.github.cenkserkan.domain.recipe.model.Recipe
import java.util.*

interface RecipeSearchUseCase {

    fun getByIngredients(ids: List<UUID>): List<Recipe>
}
