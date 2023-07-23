package com.github.cenkserkan.infra.adapters.recipe.rest.controller

import com.github.cenkserkan.domain.userAuth.usecase.UserAuthUseCase
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
class UserAuthController(
    private val userAuthUseCase: UserAuthUseCase
) {
    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest, response: HttpServletResponse): ResponseEntity<String> {
        val cookie = userAuthUseCase.login(userName = request.userName, password = request.password)

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body("Login Successful!")
    }

    @PostMapping("/logout")
    fun logOut(): ResponseEntity<String> {
        val cleanCookie = userAuthUseCase.logOut()

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cleanCookie.toString())
            .body("You've been signed out!")
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<String> {
        userAuthUseCase.register(userName = request.userName, email = request.email, password = request.password)

        return ResponseEntity.ok("User registered successfully!")
    }
}
