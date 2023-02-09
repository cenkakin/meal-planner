package com.github.cenkserkan.infra.adapters.aggregateRecipe.persistence

import com.github.cenkserkan.domain.aggregateRecipe.model.AggregateRecipe
import com.github.cenkserkan.domain.aggregateRecipe.port.AggregateRecipePort
import com.github.cenkserkan.infra.adapters.aggregateRecipe.persistence.repository.AggregateRecipeRepository
import java.util.UUID

class AggregateRecipePersistenceAdapter(private val aggregateRecipeRepository: AggregateRecipeRepository): AggregateRecipePort {
    override fun findAggregateRecipesByIngredients(ids: List<UUID>): List<AggregateRecipe> {
        TODO("Call repository and return the domain object here")
    }
}