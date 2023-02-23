package com.github.cenkserkan.domain.recipe.port

import com.github.cenkserkan.domain.recipe.model.Ingredient

interface IngredientPort {

    fun getIngredients(): List<Ingredient>
}
