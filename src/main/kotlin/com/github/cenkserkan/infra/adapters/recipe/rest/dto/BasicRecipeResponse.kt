package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.BasicRecipe
import com.github.cenkserkan.domain.recipe.model.FSALights
import java.util.UUID

data class BasicRecipeResponse(
    val id: UUID,
    val title: String,
    val fsaLights: FSALights,
    val recipeImages: List<String>?
) {
    companion object {
        fun from(recipe: BasicRecipe) = with(recipe) {
            BasicRecipeResponse(
                id = id,
                title = title,
                fsaLights = fsaLights,
                recipeImages = recipeImages
            )
        }
    }
}
