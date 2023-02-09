package com.github.cenkserkan.domain.aggregateRecipe

import com.github.cenkserkan.domain.aggregateRecipe.model.AggregateRecipe
import com.github.cenkserkan.domain.aggregateRecipe.usecase.AggregateRecipeSearchUsecase
import java.util.UUID

class AggregateRecipeHandler(
//    private val aggregateRecipePort: AggregateRecipePort
    private val getRecipeByIdUseCase: GetRecipeByIdUseCase,
    private val getRecipeIngredientsByRecipeIdUseCase: GetRecipeIngredientsByRecipeIdUseCase
) : AggregateRecipeSearchUsecase {
    override fun getById(ids: List<UUID>): List<AggregateRecipe> {
        // val recipe = getRecipeByIdUseCase(id)
        // val recipeIngredients = getRecipeIngredientsByRecipeIdUseCase(id)
        // agg
        return aggregateRecipePort.findAggregateRecipesByIngredients(ids = ids)
    }
}
