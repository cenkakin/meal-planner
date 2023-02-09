package com.github.cenkserkan.domain.aggregateRecipe

import com.github.cenkserkan.domain.aggregateRecipe.model.AggregateRecipe
import com.github.cenkserkan.domain.aggregateRecipe.port.AggregateRecipePort
import com.github.cenkserkan.domain.aggregateRecipe.usecase.AggregateRecipeSearchUsecase
import java.util.UUID

class AggregateRecipeHandler(private val aggregateRecipePort: AggregateRecipePort): AggregateRecipeSearchUsecase {
    override fun getByIds(ids: List<UUID>): List<AggregateRecipe> {
        return aggregateRecipePort.findAggregateRecipesByIngredients(ids = ids)
    }
}