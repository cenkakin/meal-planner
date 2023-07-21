package com.github.cenkserkan.domain.user.port

import com.github.cenkserkan.domain.user.model.User
import java.util.UUID

interface UserPort {
    fun getUser(id: UUID): User?
}
