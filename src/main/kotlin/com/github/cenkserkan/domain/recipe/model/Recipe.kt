package com.github.cenkserkan.domain.recipe.model

import java.util.UUID

data class Recipe(val id: UUID, val name: String, val cuisine: String)
