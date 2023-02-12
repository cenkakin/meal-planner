package com.github.cenkserkan.domain.recipe.model

import java.util.UUID

data class Ingredient(val id: UUID, val name: String, val type: String, val unit: String, val weight: Int)
