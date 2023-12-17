package com.github.cenkserkan.auth

import com.github.cenkserkan.auth.model.User
import org.springframework.security.core.userdetails.UserDetailsService

class UserDetailsHandler(
    private val userPort: UserPort
) : UserDetailsService {
    override fun loadUserByUsername(email: String): User {
        return checkNotNull(userPort.findByEmail(email = email)) { "User doesn't exist" }
    }
}
