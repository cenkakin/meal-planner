package com.github.cenkserkan.domain.ingredient.model

import java.util.UUID

data class Ingredient(val id: UUID, val name: String, val unit: String, val weight: Int)
