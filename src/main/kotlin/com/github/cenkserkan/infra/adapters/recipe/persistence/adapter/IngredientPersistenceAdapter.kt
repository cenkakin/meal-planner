package com.github.cenkserkan.infra.adapters.recipe.persistence.adapter

import com.github.cenkserkan.domain.recipe.model.Ingredient
import com.github.cenkserkan.domain.recipe.port.IngredientPort
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.IngredientRepository

class IngredientPersistenceAdapter(private val ingredientsRepository: IngredientRepository) : IngredientPort {
    override fun getIngredients(): List<Ingredient> {
        return ingredientsRepository.getIngredients()
    }
}
