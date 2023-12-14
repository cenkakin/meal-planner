package com.github.cenkserkan.configuration

import com.github.cenkserkan.auth.jwt.JwtService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    @Value("\${mealplanner.app.jwtSecret}")
    val secretKey: String,
    @Value("\${mealplanner.app.jwtExpirationMs}")
    val expirationMs: Long
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests { auth ->
                auth.requestMatchers("/v1/auth/**").permitAll()
                    .requestMatchers("/v1/**").hasAuthority("ROLE_USER")
                    .anyRequest().authenticated()
            }
            .headers().frameOptions().disable()

        http.cors()

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
    @Bean
    fun createJwtService() = JwtService(secretKey, expirationMs)
}
