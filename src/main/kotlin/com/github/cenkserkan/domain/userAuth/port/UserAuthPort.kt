package com.github.cenkserkan.domain.userAuth.port

import com.github.cenkserkan.domain.userAuth.model.User
import java.util.UUID

interface UserAuthPort {
    fun findById(id: UUID): User?

    fun findByEmail(email: String): User?

    fun findByUserName(userName: String): User?

    fun save(userName: String, password: String, email: String, role: String): User
}
