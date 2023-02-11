package com.github.cenkserkan.infra.adapters.recipe.rest

import com.github.cenkserkan.domain.recipe.usecase.RecipeRetrievalUseCase
import com.github.cenkserkan.domain.recipe.usecase.RecipeSearchUseCase
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.ExpandedRecipeResponse
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.RecipeListResponse
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.RecipeResponse
import jakarta.validation.constraints.NotEmpty
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1/recipe")
@Validated
class RecipeController(
    private val recipeSearchUseCase: RecipeSearchUseCase,
    private val recipeRetrievalUseCase: RecipeRetrievalUseCase,
) {

    @GetMapping("/search")
    fun searchByIngredients(
        @NotEmpty
        @RequestParam
        ingredientIds: List<UUID>,
    ): ResponseEntity<RecipeListResponse> {
        val recipes = recipeSearchUseCase.getByIngredients(ingredientIds)
        val recipeListResponse = RecipeListResponse(recipes.map { RecipeResponse.from(it) })
        return ResponseEntity.ok(recipeListResponse)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): ResponseEntity<ExpandedRecipeResponse> {
        val recipeWithExpandedIngredients = recipeRetrievalUseCase.getRecipeWithIngredientsById(id)
        return ResponseEntity.ok(ExpandedRecipeResponse.from(recipeWithExpandedIngredients))
    }
}
