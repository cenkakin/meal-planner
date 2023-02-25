package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.recipe.model.BasicRecipe
import java.util.UUID

data class BasicRecipeResponse(
    val id: UUID,
    val name: String,
    val cuisine: String,
    val summary: String?,
    val photo: String?,
) {
    companion object {
        fun from(recipe: BasicRecipe) = with(recipe) {
            BasicRecipeResponse(
                id = id,
                name = name,
                cuisine = cuisine,
                summary = summary,
                photo = photo,
            )
        }
    }
}
