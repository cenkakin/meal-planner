package com.github.cenkserkan.infra.adapters.ingredient.persistent

import com.github.cenkserkan.domain.ingredient.model.Ingredient
import com.github.cenkserkan.domain.ingredient.port.IngredientPort
import com.github.cenkserkan.infra.adapters.ingredient.persistent.repository.IngredientRepository
import java.util.UUID

class IngredientPersistenceAdapter(private val ingredientRepository: IngredientRepository) : IngredientPort {
    override fun getByIds(ids: List<UUID>): List<Ingredient> {
        return ingredientRepository.getByIds(ids)
    }
}
