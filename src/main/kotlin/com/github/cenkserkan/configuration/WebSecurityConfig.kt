package com.github.cenkserkan.configuration

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
class WebSecurityConfig {
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
}
