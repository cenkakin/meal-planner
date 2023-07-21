package com.github.cenkserkan.domain.user.model

import java.util.UUID

data class User(val id: UUID, val userName: String, val password: String, val email: String)
