package com.github.cenkserkan.infra.adapters.recipe.persistence.adapter

import com.github.cenkserkan.auth.User
import com.github.cenkserkan.auth.UserAdapter
import com.github.cenkserkan.auth.UserPort
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class UserPersistenceAdapter(private val userRepository: UserRepository) : UserPort, UserDetailsService {

    override fun findByEmail(email: String): User? {
        return userRepository.findUserByEmail(email = email)
    }

    override fun findByUserName(userName: String): User? {
        return userRepository.findUserByUserName(userName = userName)
    }

    override fun save(user: User): User {
        return userRepository.saveUser(user)
    }

    override fun loadUserByUsername(email: String): UserDetails {
        val user = checkNotNull(userRepository.findUserByEmail(email = email)) { "User doesn't exist" }

        return UserAdapter(user = user)
    }
}
