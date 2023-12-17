package com.github.cenkserkan.infra.userAuth.rest.dto

import com.github.cenkserkan.auth.model.Role
import com.github.cenkserkan.auth.model.User

data class RegisterRequest(val userName: String, val email: String, val password: String) {

    fun toUser(): User {
        return User(email = email, username = userName, password = password, authorities = listOf(Role.ROLE_USER))
    }
}
