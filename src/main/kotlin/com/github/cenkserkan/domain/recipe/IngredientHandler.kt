package com.github.cenkserkan.domain.recipe

import com.github.cenkserkan.domain.recipe.model.Ingredient
import com.github.cenkserkan.domain.recipe.port.IngredientPort
import com.github.cenkserkan.domain.recipe.usecase.IngredientsRetrievalUseCase

class IngredientHandler(private val ingredientPort: IngredientPort) : IngredientsRetrievalUseCase {
    override fun getIngredients(): List<Ingredient> {
        return ingredientPort.getIngredients()
    }
}
