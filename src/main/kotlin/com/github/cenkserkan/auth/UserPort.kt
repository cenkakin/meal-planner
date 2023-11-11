package com.github.cenkserkan.auth

interface UserPort {
    fun findByEmail(email: String): User?

    fun findByUserName(userName: String): User?

    fun save(user: User): User
}
