package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.RecipeCreateCommand

data class RecipeRequest(val id: String) {

    fun toRecipeCreateCommand(): RecipeCreateCommand {
        return RecipeCreateCommand(id)
    }
}
