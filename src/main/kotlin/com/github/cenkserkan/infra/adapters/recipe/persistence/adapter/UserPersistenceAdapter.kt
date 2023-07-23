package com.github.cenkserkan.infra.adapters.recipe.persistence.adapter

import com.github.cenkserkan.domain.userAuth.model.User
import com.github.cenkserkan.domain.userAuth.port.UserAuthPort
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.UserRepository
import java.util.UUID

class UserPersistenceAdapter(private val userRepository: UserRepository) : UserAuthPort {
    override fun findById(id: UUID): User? {
        return userRepository.findUserById(id = id)
    }

    override fun findByEmail(email: String): User? {
        return userRepository.findUserByEmail(email = email)
    }

    override fun findByUserName(userName: String): User? {
        return userRepository.findUserByUserName(userName = userName)
    }

    override fun save(userName: String, password: String, email: String, role: String): User {
        return userRepository.saveUser(userName = userName, password = password, email = email, role = role)
    }
}
