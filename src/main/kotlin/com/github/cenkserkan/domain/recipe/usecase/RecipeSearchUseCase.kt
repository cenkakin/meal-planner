package com.github.cenkserkan.domain.recipe.usecase

import com.github.cenkserkan.domain.recipe.model.BasicRecipe
import java.util.*

interface RecipeSearchUseCase {

    fun getByIngredients(ids: List<UUID>): List<BasicRecipe>
}
