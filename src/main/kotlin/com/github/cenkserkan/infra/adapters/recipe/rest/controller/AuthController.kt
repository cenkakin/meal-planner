package com.github.cenkserkan.infra.adapters.recipe.rest.controller

import com.github.cenkserkan.auth.AuthUsecase
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.LoginRequest
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.RegisterRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/auth")
class AuthController(
    private val authUsecase: AuthUsecase
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<String> {
        return ResponseEntity.ok(authUsecase.register(request.toUser()))
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<String> {
        return ResponseEntity.ok(authUsecase.login(email = request.email, password = request.password))
    }

    @PostMapping("/logout")
    fun logOut(): ResponseEntity<String> {
        TODO("NOT IMPLEMENTED")
    }
}
