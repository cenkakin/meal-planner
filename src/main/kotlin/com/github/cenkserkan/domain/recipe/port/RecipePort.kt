package com.github.cenkserkan.domain.recipe.port

import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.domain.recipe.model.RecipeIngredient
import java.util.UUID

interface RecipePort {

    fun findRecipesByIngredients(ids: List<UUID>): List<Recipe>
    fun getById(id: UUID): Recipe?

    fun getRecipeIngredients(id: UUID): List<RecipeIngredient>
}
