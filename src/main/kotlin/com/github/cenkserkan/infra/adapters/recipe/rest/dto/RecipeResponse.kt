package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.Recipe

data class RecipeResponse(val id: String) {

    companion object {
        fun from(recipe: Recipe): RecipeResponse {
            TODO("Not yet implemented")
        }
    }
}
