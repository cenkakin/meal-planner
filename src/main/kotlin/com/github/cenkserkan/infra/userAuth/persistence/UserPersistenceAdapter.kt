package com.github.cenkserkan.infra.userAuth.persistence

import com.github.cenkserkan.auth.UserPort
import com.github.cenkserkan.auth.model.User

class UserPersistenceAdapter(private val userRepository: UserRepository) : UserPort {

    override fun findByEmail(email: String): User? {
        return userRepository.findUserByEmail(email = email)
    }

    override fun findByUserName(userName: String): User? {
        return userRepository.findUserByUserName(userName = userName)
    }

    override fun save(user: User): User {
        return userRepository.saveUser(user)
    }
}
