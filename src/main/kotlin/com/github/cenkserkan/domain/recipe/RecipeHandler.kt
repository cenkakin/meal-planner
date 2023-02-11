package com.github.cenkserkan.domain.recipe

import com.github.cenkserkan.domain.ingredient.usecase.IngredientsRetrievalUseCase
import com.github.cenkserkan.domain.recipe.model.ExpandedRecipeIngredient
import com.github.cenkserkan.domain.recipe.model.Recipe
import com.github.cenkserkan.domain.recipe.model.RecipeIngredient
import com.github.cenkserkan.domain.recipe.model.RecipeWithExpandedIngredients
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.domain.recipe.usecase.InvalidRecipeException
import com.github.cenkserkan.domain.recipe.usecase.RecipeNotFoundException
import com.github.cenkserkan.domain.recipe.usecase.RecipeRetrievalUseCase
import com.github.cenkserkan.domain.recipe.usecase.RecipeSearchUseCase
import java.util.UUID

class RecipeHandler(
    private val ingredientsRetrievalUseCase: IngredientsRetrievalUseCase,
    private val recipePort: RecipePort,
) : RecipeSearchUseCase, RecipeRetrievalUseCase {

    override fun getByIngredients(ids: List<UUID>): List<Recipe> {
        return recipePort.findRecipesByIngredients(ids)
    }

    override fun getRecipeWithIngredientsById(id: UUID): RecipeWithExpandedIngredients {
        val recipe = recipePort.getById(id) ?: throw RecipeNotFoundException(id)
        val recipeIngredients = getExpandedRecipeIngredients(id)
        return RecipeWithExpandedIngredients(recipe, recipeIngredients)
    }

    private fun getExpandedRecipeIngredients(id: UUID): List<ExpandedRecipeIngredient> {
        val recipeIngredients = recipePort.getRecipeIngredients(id)
        if (recipeIngredients.isEmpty()) {
            throw InvalidRecipeException("Ingredients cannot be empty, recipeId: $id")
        }
        val ingredientById = ingredientsRetrievalUseCase.getIngredientsByIds(recipeIngredients.map { it.ingredientId })
            .associateBy { it.id }

        return recipeIngredients.map {
            ExpandedRecipeIngredient(it.recipeId, ingredientById.getValue(it.ingredientId), it.quantity)
        }
    }
}
