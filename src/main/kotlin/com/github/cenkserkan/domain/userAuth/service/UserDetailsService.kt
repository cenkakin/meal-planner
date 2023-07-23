package com.github.cenkserkan.domain.userAuth.service

import com.github.cenkserkan.domain.userAuth.port.UserAuthPort
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class UserDetailsService(private val userAuthPort: UserAuthPort) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userAuthPort.findByUserName(userName = username) ?: throw Exception("User not found!")
        val grantedAuthority = listOf(SimpleGrantedAuthority(user.role))

        return User.builder().username(user.userName).password(user.password).authorities(grantedAuthority).build()
    }
}
