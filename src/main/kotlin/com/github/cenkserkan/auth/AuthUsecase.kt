package com.github.cenkserkan.auth

import com.github.cenkserkan.auth.model.User

interface AuthUsecase {

    fun login(email: String, password: String): String
    fun register(user: User): String
    fun logout()
}
