package com.github.cenkserkan.infra.adapters.recipe.rest.controller

import app.domain.handler.AuthHandler
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.LoginRequest
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.RegisterRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/auth")
class AuthController(
    private val authHandler: AuthHandler
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<String> {
        authHandler.register(request.toUser())

        return ResponseEntity.ok("User registered successfully!")
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest, response: HttpServletResponse): ResponseEntity<String> {
        val cookie = authHandler.login(email = request.userName, password = request.password)

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body("Login Successful!")
    }

    @PostMapping("/logout")
    fun logOut(): ResponseEntity<String> {
        // val cleanCookie = authHandler.logOut()
        //
        // return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cleanCookie.toString())
        //     .body("You've been signed out!")

        TODO("NOT IMPLEMENTED")
    }
}
