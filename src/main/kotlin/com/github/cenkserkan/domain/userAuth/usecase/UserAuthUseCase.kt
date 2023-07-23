package com.github.cenkserkan.domain.userAuth.usecase

import org.springframework.http.ResponseCookie

interface UserAuthUseCase {

    fun login(userName: String, password: String): ResponseCookie

    fun logOut(): ResponseCookie

    fun register(userName: String, email: String, password: String)
}
