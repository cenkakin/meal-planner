package com.github.cenkserkan.configuration

import com.github.cenkserkan.domain.calendar.handler.CalendarHandler
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.domain.recipe.handler.IngredientHandler
import com.github.cenkserkan.domain.recipe.handler.RecipeHandler
import com.github.cenkserkan.domain.recipe.port.IngredientPort
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.infra.calendar.persistence.adapter.CalendarPersistenceAdapter
import com.github.cenkserkan.infra.calendar.persistence.repository.CalendarRepository
import com.github.cenkserkan.infra.recipe.persistence.repository.RecipeIngredientsRepository
import com.github.cenkserkan.infra.recipe.persistence.repository.RecipeRepository
import com.github.cenkserkan.infra.userAuth.persistence.UserPersistenceAdapter
import com.github.cenkserkan.infra.userAuth.persistence.UserRepository
import org.jooq.DSLContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MealPlannerConfiguration {

    @Bean
    fun recipePersistenceAdapter(dslContext: DSLContext): com.github.cenkserkan.infra.recipe.persistence.adapter.RecipePersistenceAdapter {
        return com.github.cenkserkan.infra.recipe.persistence.adapter.RecipePersistenceAdapter(
            RecipeIngredientsRepository(dslContext),
            RecipeRepository(dslContext)
        )
    }

    @Bean
    fun recipeHandler(recipePort: RecipePort): RecipeHandler {
        return RecipeHandler(recipePort)
    }

    @Bean
    fun ingredientPersistenceAdapter(dslContext: DSLContext): com.github.cenkserkan.infra.recipe.persistence.adapter.IngredientPersistenceAdapter {
        val ingredientsRepository =
            com.github.cenkserkan.infra.recipe.persistence.repository.IngredientRepository(dslContext)
        return com.github.cenkserkan.infra.recipe.persistence.adapter.IngredientPersistenceAdapter(ingredientsRepository)
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

    @Bean
    fun userPersistenceAdapter(dslContext: DSLContext): UserPersistenceAdapter {
        return UserPersistenceAdapter(UserRepository(dslContext))
    }
}
