package com.github.cenkserkan.infra.adapters.recipe.rest

import com.github.cenkserkan.domain.recipe.usecase.RecipeCreateUseCase
import com.github.cenkserkan.domain.recipe.usecase.RecipeGetUseCase
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.RecipeRequest
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.RecipeResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/recipe")
class RecipeController(
    private val recipeGetUseCase: RecipeGetUseCase,
    private val recipeCreateUseCase: RecipeCreateUseCase,
) {

    @GetMapping("/{id}")
    fun getRecipe(@PathVariable id: String): ResponseEntity<RecipeResponse> {
        val recipe = recipeGetUseCase.getRecipe(id)
        return ResponseEntity.ok(RecipeResponse.from(recipe))
    }

    @PostMapping
    fun createRecipe(@RequestBody recipeRequest: RecipeRequest): ResponseEntity<RecipeResponse> {
        val recipe = recipeCreateUseCase.createRecipe(recipeRequest.toRecipeCreateCommand())
        return ResponseEntity.ok(RecipeResponse.from(recipe))
    }
}
