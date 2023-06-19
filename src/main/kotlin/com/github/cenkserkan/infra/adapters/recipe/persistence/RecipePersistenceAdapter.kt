package com.github.cenkserkan.infra.adapters.recipe.persistence

import com.github.cenkserkan.domain.recipe.model.BasicRecipe
import com.github.cenkserkan.domain.recipe.model.RecipeIngredient
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeIngredientsRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeRepository
import java.util.UUID

class RecipePersistenceAdapter(
    private val recipeIngredientsRepository: RecipeIngredientsRepository,
    private val recipeRepository: RecipeRepository
) : RecipePort {

    override fun findRecipesByIngredients(ids: List<UUID>): List<BasicRecipe> {
        val recipeIds = recipeIngredientsRepository.findRecipeIdsByIngredients(ids)
        return recipeRepository.findByIds(recipeIds)
    }

    override fun getById(id: UUID): BasicRecipe? {
        return recipeRepository.getBasicRecipeById(id)
    }

    override fun getRecipeIngredients(id: UUID): List<RecipeIngredient> {
        return recipeIngredientsRepository.getRecipeIngredientsByRecipeId(id)
    }

    override fun getRecipeInstructions(id: UUID): List<String> {
        return recipeRepository.getInstructionsByRecipeId(id)
    }
}
