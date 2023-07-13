package com.github.cenkserkan.configuration

import com.github.cenkserkan.domain.calendar.handler.CalendarHandler
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.domain.recipe.handler.IngredientHandler
import com.github.cenkserkan.domain.recipe.handler.RecipeHandler
import com.github.cenkserkan.domain.recipe.port.IngredientPort
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.infra.adapters.recipe.persistence.CalendarPersistenceAdapter
import com.github.cenkserkan.infra.adapters.recipe.persistence.IngredientPersistenceAdapter
import com.github.cenkserkan.infra.adapters.recipe.persistence.RecipePersistenceAdapter
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.CalendarRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.IngredientRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeIngredientsRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeRepository
import org.jooq.DSLContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MealPlannerConfiguration {

    @Bean
    fun recipePersistenceAdapter(dslContext: DSLContext): RecipePersistenceAdapter {
        return RecipePersistenceAdapter(RecipeIngredientsRepository(dslContext), RecipeRepository(dslContext))
    }

    @Bean
    fun recipeHandler(recipePort: RecipePort): RecipeHandler {
        return RecipeHandler(recipePort)
    }

    @Bean
    fun ingredientPersistenceAdapter(dslContext: DSLContext): IngredientPersistenceAdapter {
        val ingredientsRepository = IngredientRepository(dslContext)
        return IngredientPersistenceAdapter(ingredientsRepository)
    }

    @Bean
    fun ingredientHandler(ingredientPort: IngredientPort): IngredientHandler {
        return IngredientHandler(ingredientPort)
    }

    @Bean
    fun calendarPersistenceAdapter(): CalendarPersistenceAdapter {
        return CalendarPersistenceAdapter(CalendarRepository())
    }

    @Bean
    fun calendarHandler(calendarPort: CalendarPort): CalendarHandler {
        return CalendarHandler(calendarPort)
    }
}
