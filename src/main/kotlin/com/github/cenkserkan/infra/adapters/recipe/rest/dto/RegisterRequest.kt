package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.userAuth.model.Role
import com.github.cenkserkan.auth.User as User

data class RegisterRequest(val userName: String, val email: String, val password: String) {

    fun toUser(): User {
        return User(email = email, userName = userName, password = password, authorities = listOf(Role.ROLE_USER))
    }
}
