package com.github.cenkserkan.infra.adapters.aggregateRecipe.rest

import com.github.cenkserkan.domain.aggregateRecipe.model.AggregateRecipe
import com.github.cenkserkan.domain.aggregateRecipe.usecase.AggregateRecipeSearchUsecase
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/aggregateRecipe")
@Validated
class AggregateRecipeController (private val aggregateRecipeSearchUsecase: AggregateRecipeSearchUsecase) {

    @GetMapping
    fun searchById(id: UUID): ResponseEntity<AggregateRecipeResponse>

}