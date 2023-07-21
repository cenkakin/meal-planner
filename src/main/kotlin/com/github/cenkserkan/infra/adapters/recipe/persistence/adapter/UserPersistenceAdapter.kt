package com.github.cenkserkan.infra.adapters.recipe.persistence.adapter

import com.github.cenkserkan.domain.user.model.User
import com.github.cenkserkan.domain.user.port.UserPort
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.UserRepository
import java.util.UUID

class UserPersistenceAdapter(private val userRepository: UserRepository) : UserPort {
    override fun getUser(id: UUID): User? {
        return userRepository.getUserById(id = id)
    }
}
