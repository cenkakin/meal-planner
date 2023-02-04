package com.github.cenkserkan.infra.adapters.recipe.persistence

import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeIngredientsRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeRepository
import java.util.UUID

class RecipePersistenceAdapter(
    private val recipeIngredientsRepository: RecipeIngredientsRepository,
    private val recipeRepository: RecipeRepository,
) : RecipePort {

    override fun findRecipesByIngredients(ids: List<UUID>): List<Recipe> {
        val recipeIds = recipeIngredientsRepository.findRecipeIdsByIngredients(ids)
        return recipeRepository.findByIds(recipeIds)
    }
}
