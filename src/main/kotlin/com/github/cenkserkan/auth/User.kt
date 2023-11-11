package com.github.cenkserkan.auth

import com.github.cenkserkan.domain.userAuth.model.Role

data class User(
    val userName: String,
    val password: String,
    val email: String,
    val authorities: List<Role>
)
