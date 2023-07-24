package com.github.cenkserkan.configuration

import com.github.cenkserkan.domain.calendar.handler.CalendarHandler
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.domain.recipe.handler.IngredientHandler
import com.github.cenkserkan.domain.recipe.handler.RecipeHandler
import com.github.cenkserkan.domain.recipe.port.IngredientPort
import com.github.cenkserkan.domain.recipe.port.RecipePort
import com.github.cenkserkan.domain.userAuth.handler.UserAuthHandler
import com.github.cenkserkan.domain.userAuth.port.UserAuthPort
import com.github.cenkserkan.domain.userAuth.service.UserDetailsService
import com.github.cenkserkan.infra.adapters.recipe.persistence.adapter.CalendarPersistenceAdapter
import com.github.cenkserkan.infra.adapters.recipe.persistence.adapter.IngredientPersistenceAdapter
import com.github.cenkserkan.infra.adapters.recipe.persistence.adapter.RecipePersistenceAdapter
import com.github.cenkserkan.infra.adapters.recipe.persistence.adapter.UserPersistenceAdapter
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.CalendarRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.IngredientRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeIngredientsRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.RecipeRepository
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.UserRepository
import com.github.cenkserkan.util.JwtUtils
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

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
    fun calendarPersistenceAdapter(dslContext: DSLContext): CalendarPersistenceAdapter {
        return CalendarPersistenceAdapter(CalendarRepository(dslContext))
    }

    @Bean
    fun calendarHandler(calendarPort: CalendarPort): CalendarHandler {
        return CalendarHandler(calendarPort)
    }

    @Bean
    fun userPersistenceAdapter(dslContext: DSLContext): UserPersistenceAdapter {
        return UserPersistenceAdapter(UserRepository(dslContext))
    }

    @Bean
    fun userAuthHandler(
        userAuthPort: UserAuthPort,
        authenticationManager: AuthenticationManager,
        jwtUtils: JwtUtils,
        encoder: PasswordEncoder
    ): UserAuthHandler {
        return UserAuthHandler(
            userAuthPort = userAuthPort,
            authenticationManager = authenticationManager,
            jwtUtils = jwtUtils,
            encoder = encoder
        )
    }

    @Bean
    fun userDetailsService(userAuthPort: UserAuthPort): UserDetailsService {
        return UserDetailsService(userAuthPort = userAuthPort)
    }

    @Bean
    fun jwtUtils(
        @Value("\${mealplanner.app.jwtSecret}")
        jwtSecret: String,

        @Value("\${mealplanner.app.jwtExpirationMs}")
        jwtExpirationMs: Long,

        @Value("\${mealplanner.app.jwtCookieName}")
        jwtCookie: String
    ): JwtUtils {
        return JwtUtils(jwtSecret = jwtSecret, jwtExpirationMs = jwtExpirationMs, jwtCookie = jwtCookie)
    }

    @Bean
    fun authTokenFilter(): AuthEntryPointJwt {
        return AuthEntryPointJwt()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}
