package com.github.cenkserkan.domain.aggregateRecipe.port

import com.github.cenkserkan.domain.aggregateRecipe.model.AggregateRecipe
import java.util.UUID

interface AggregateRecipePort {
    fun findAggregateRecipesByIngredients(ids: List<UUID>): List<AggregateRecipe>
}