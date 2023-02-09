package com.github.cenkserkan.configuration

import com.github.cenkserkan.domain.aggregateRecipe.AggregateRecipeHandler
import com.github.cenkserkan.domain.aggregateRecipe.port.AggregateRecipePort
import com.github.cenkserkan.domain.recipe.RecipeHandler
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.infra.adapters.aggregateRecipe.persistence.AggregateRecipePersistenceAdapter
import com.github.cenkserkan.infra.adapters.aggregateRecipe.persistence.repository.AggregateRecipeRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.RecipePersistenceAdapter
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeIngredientsRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeRepository
import org.jooq.DSLContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MealPlannerConfiguration {

    @Bean
    fun recipePort(dslContext: DSLContext): RecipePersistenceAdapter {
        return RecipePersistenceAdapter(RecipeIngredientsRepository(dslContext), RecipeRepository(dslContext))
    }

    @Bean
    fun recipeHandler(recipePort: RecipePort): RecipeHandler {
        return RecipeHandler(recipePort)
    }

    @Bean
    fun aggregateRecipePort(dslContext: DSLContext): AggregateRecipePort{
        return AggregateRecipePersistenceAdapter(AggregateRecipeRepository(dslContext = dslContext))
    }

    @Bean
    fun aggregateRecipeHandler(aggregateRecipePort: AggregateRecipePort): AggregateRecipeHandler{
        return AggregateRecipeHandler(aggregateRecipePort = aggregateRecipePort)
    }
}
