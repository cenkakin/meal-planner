package com.github.cenkserkan.domain.aggregateRecipe.usecase

import com.github.cenkserkan.domain.aggregateRecipe.model.AggregateRecipe
import java.util.UUID

interface AggregateRecipeSearchUsecase {
    fun getById(ids: List<UUID>): List<AggregateRecipe>
}