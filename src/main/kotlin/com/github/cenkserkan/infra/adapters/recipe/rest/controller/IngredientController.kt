package com.github.cenkserkan.infra.adapters.recipe.rest.controller

import com.github.cenkserkan.domain.recipe.usecase.IngredientsRetrievalUseCase
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.IngredientListResponse
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.IngredientResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/ingredient")
class IngredientController(private val ingredientsRetrievalUseCase: IngredientsRetrievalUseCase) {

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    fun getIngredients(): ResponseEntity<IngredientListResponse> {
        val ingredients = ingredientsRetrievalUseCase.getIngredients().map { IngredientResponse.from(it) }
        return ResponseEntity.ok(IngredientListResponse(ingredients))
    }
}
