package com.github.cenkserkan.infra.recipe.persistence.adapter

import com.github.cenkserkan.domain.recipe.model.Ingredient
import com.github.cenkserkan.domain.recipe.port.IngredientPort
import com.github.cenkserkan.infra.recipe.persistence.repository.IngredientRepository

class IngredientPersistenceAdapter(private val ingredientsRepository: com.github.cenkserkan.infra.recipe.persistence.repository.IngredientRepository) : IngredientPort {
    override fun getIngredients(): List<Ingredient> {
        return ingredientsRepository.getIngredients()
    }
}
