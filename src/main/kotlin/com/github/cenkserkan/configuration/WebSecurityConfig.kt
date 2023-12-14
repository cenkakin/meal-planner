package com.github.cenkserkan.configuration

import com.github.cenkserkan.auth.jwt.JwtAuthFilter
import com.github.cenkserkan.auth.UserDetailsHandler
import com.github.cenkserkan.auth.UserPort
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
    ): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests { auth ->
                auth.requestMatchers("/v1/auth/**").permitAll()
                    .requestMatchers("/v1/**").hasAuthority("ROLE_USER")
                    .anyRequest().authenticated()
            }
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
    fun createJwtAuthFilter(
        jwtService: JwtService,
        userDetailsHandler: UserDetailsHandler
    ): JwtAuthFilter = JwtAuthFilter(jwtService, userDetailsHandler)

    @Bean
    fun createJwtService() = JwtService(secretKey, expirationMs)

    @Bean
    fun createUserDetailsHandler(
        userPort: UserPort
    ): UserDetailsHandler = UserDetailsHandler(userPort)
}
