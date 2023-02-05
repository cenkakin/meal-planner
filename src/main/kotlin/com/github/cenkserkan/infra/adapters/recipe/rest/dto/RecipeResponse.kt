package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.Recipe
import java.util.UUID

data class RecipeResponse(val id: UUID, val name: String, val cuisine: String) {

    companion object {
        fun from(recipe: Recipe) = RecipeResponse(recipe.id, recipe.name, recipe.cuisine)
    }
}
