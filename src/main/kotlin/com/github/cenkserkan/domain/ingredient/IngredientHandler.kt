package com.github.cenkserkan.domain.ingredient

import com.github.cenkserkan.domain.ingredient.model.Ingredient
import com.github.cenkserkan.domain.ingredient.model.IngredientsNotFoundException
import com.github.cenkserkan.domain.ingredient.port.IngredientPort
import com.github.cenkserkan.domain.ingredient.usecase.IngredientsRetrievalUseCase
import java.util.UUID

class IngredientHandler(private val ingredientPort: IngredientPort) : IngredientsRetrievalUseCase {
    override fun getIngredientsByIds(ids: List<UUID>): List<Ingredient> {
        val ingredients = ingredientPort.getByIds(ids)
        if (ingredients.size != ids.size) {
            val missingIds = ids - ingredients.map { it.id }.toSet()
            throw IngredientsNotFoundException(missingIds)
        }
        return ingredients
    }
}
