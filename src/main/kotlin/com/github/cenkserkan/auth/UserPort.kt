package com.github.cenkserkan.auth

import com.github.cenkserkan.auth.model.User

interface UserPort {
    fun findByEmailOrThrow(email: String): User

    fun findByEmail(email: String): User?

    fun save(user: User): User
}
