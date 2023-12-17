package com.github.cenkserkan.configuration

import app.domain.handler.AuthHandler
import com.github.cenkserkan.auth.UserDetailsHandler
import com.github.cenkserkan.auth.UserPort
import com.github.cenkserkan.auth.jwt.JwtAuthFilter
import com.github.cenkserkan.auth.jwt.JwtService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    @Value("\${mealplanner.app.jwtSecret}")
    val secretKey: String,
    @Value("\${mealplanner.app.jwtExpirationMs}")
    val expirationMs: Long
) {

    @Bean
    fun filterChain(
        http: HttpSecurity,
        jwtAuthFilter: JwtAuthFilter,
        authenticationManager: AuthenticationManager
    ): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests { auth ->
                auth.requestMatchers("/v1/auth/**").permitAll()
                    .requestMatchers("/v1/**").hasAuthority("ROLE_USER")
                    .anyRequest().authenticated()
            }
            .sessionManagement { customizer ->
                customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authenticationManager(authenticationManager)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
            .headers().frameOptions().disable()

        http.cors()

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(
        userDetailsHandler: UserDetailsHandler,
        passwordEncoder: PasswordEncoder
    ): AuthenticationManager {
        val authenticationProvider = DaoAuthenticationProvider()
        authenticationProvider.setUserDetailsService(userDetailsHandler)
        authenticationProvider.setPasswordEncoder(passwordEncoder)

        return ProviderManager(authenticationProvider)
    }

    @Bean
    fun createJwtAuthFilter(
        jwtService: JwtService,
        userDetailsHandler: UserDetailsHandler
    ): JwtAuthFilter = JwtAuthFilter(jwtService, userDetailsHandler)

    @Bean
    fun createJwtService() = JwtService(secretKey, expirationMs)

    @Bean
    fun createAuthHandler(
        port: UserPort,
        encoder: PasswordEncoder,
        jwtService: JwtService,
        authenticationManager: AuthenticationManager
    ): AuthHandler = AuthHandler(port, encoder, jwtService, authenticationManager)

    @Bean
    fun createUserDetailsHandler(
        userPort: UserPort
    ): UserDetailsHandler = UserDetailsHandler(userPort)
}
