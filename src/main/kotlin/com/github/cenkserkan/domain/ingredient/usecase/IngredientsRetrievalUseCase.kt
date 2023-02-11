package com.github.cenkserkan.domain.ingredient.usecase

import com.github.cenkserkan.domain.ingredient.model.Ingredient
import java.util.UUID

interface IngredientsRetrievalUseCase {

    fun getIngredientsByIds(ids: List<UUID>): List<Ingredient>
}
