package com.github.cenkserkan.domain.ingredient.port

import com.github.cenkserkan.domain.ingredient.model.Ingredient
import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.domain.recipe.model.RecipeIngredient
import java.util.UUID

interface IngredientPort {
    fun getByIds(ids: List<UUID>): List<Ingredient>
}
