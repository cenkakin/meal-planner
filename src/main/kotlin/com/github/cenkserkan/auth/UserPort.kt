package com.github.cenkserkan.auth

import com.github.cenkserkan.auth.model.User

interface UserPort {
    fun findByEmail(email: String): User?

    fun findByUserName(userName: String): User?

    fun save(user: User): User
}
