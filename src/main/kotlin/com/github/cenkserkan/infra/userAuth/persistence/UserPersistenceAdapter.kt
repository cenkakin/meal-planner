package com.github.cenkserkan.infra.userAuth.persistence

import com.github.cenkserkan.auth.UserNotFoundException
import com.github.cenkserkan.auth.UserPort
import com.github.cenkserkan.auth.model.User

class UserPersistenceAdapter(private val userRepository: UserRepository) : UserPort {

    override fun findByEmailOrThrow(email: String): User {
        return findByEmail(email) ?: throw UserNotFoundException(email)
    }

    override fun findByEmail(email: String): User? {
        return userRepository.findUserByEmail(email)
    }

    override fun save(user: User): User {
        return userRepository.saveUser(user)
    }
}
