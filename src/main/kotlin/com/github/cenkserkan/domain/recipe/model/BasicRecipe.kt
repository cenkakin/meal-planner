package com.github.cenkserkan.domain.recipe.model

import java.util.UUID

data class BasicRecipe(val id: UUID, val title: String, val instructions: Array<String>)
