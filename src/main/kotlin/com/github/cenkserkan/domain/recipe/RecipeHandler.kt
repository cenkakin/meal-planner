package com.github.cenkserkan.domain.recipe

import com.github.cenkserkan.domain.recipe.model.BasicRecipe
import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.domain.recipe.model.RecipeIngredient
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.domain.recipe.usecase.InvalidRecipeException
import com.github.cenkserkan.domain.recipe.usecase.RecipeNotFoundException
import com.github.cenkserkan.domain.recipe.usecase.RecipeRetrievalUseCase
import com.github.cenkserkan.domain.recipe.usecase.RecipeSearchUseCase
import java.util.UUID

class RecipeHandler(private val recipePort: RecipePort) : RecipeSearchUseCase, RecipeRetrievalUseCase {

    override fun getByIngredients(ids: List<UUID>): List<BasicRecipe> {
        return recipePort.findRecipesByIngredients(ids)
    }

    override fun getRecipeById(id: UUID): Recipe {
        val basicRecipe = recipePort.getById(id) ?: throw RecipeNotFoundException(id)
        val recipeIngredients = getRecipeIngredients(id)
        return Recipe.from(basicRecipe, recipeIngredients)
    }

    private fun getRecipeIngredients(id: UUID): List<RecipeIngredient> {
        val recipeIngredients = recipePort.getRecipeIngredients(id)
        if (recipeIngredients.isEmpty()) {
            throw InvalidRecipeException("Ingredients cannot be empty, recipeId: $id")
        }
        return recipeIngredients
    }
}
