package com.github.cenkserkan.domain.recipe.usecase

import com.github.cenkserkan.domain.recipe.model.Ingredient

interface IngredientsRetrievalUseCase {
    fun getIngredients(): List<Ingredient>
}
