package com.github.cenkserkan.domain.recipe.port

import com.github.cenkserkan.domain.recipe.model.BasicRecipe
import com.github.cenkserkan.domain.recipe.model.RecipeIngredient
import java.util.UUID

interface RecipePort {

    fun findRecipesByIngredients(ids: List<UUID>): List<BasicRecipe>

    fun getById(id: UUID): BasicRecipe?

    fun getRecipeIngredients(id: UUID): List<RecipeIngredient>
}
