package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.BasicRecipe
import java.util.UUID

data class BasicRecipeResponse(val id: UUID, val name: String, val cuisine: String) {

    companion object {
        fun from(recipe: BasicRecipe) = BasicRecipeResponse(recipe.id, recipe.name, recipe.cuisine)
    }
}
