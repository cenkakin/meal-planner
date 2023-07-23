package com.github.cenkserkan.domain.userAuth.handler

import com.github.cenkserkan.domain.userAuth.model.Role
import com.github.cenkserkan.domain.userAuth.port.UserAuthPort
import com.github.cenkserkan.domain.userAuth.usecase.UserAuthUseCase
import com.github.cenkserkan.util.JwtUtils
import org.springframework.http.ResponseCookie
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder

class UserAuthHandler(
    private val userAuthPort: UserAuthPort,
    private val authenticationManager: AuthenticationManager,
    private val jwtUtils: JwtUtils,
    private val encoder: PasswordEncoder
) : UserAuthUseCase {

    override fun login(userName: String, password: String): ResponseCookie {
        val authentication: Authentication = authenticationManager
            .authenticate(UsernamePasswordAuthenticationToken(userName, password))

        SecurityContextHolder.getContext().authentication = authentication

        val userDetails: User = authentication.principal as User

        return jwtUtils.generateJwtCookie(userDetails)
    }

    override fun logOut(): ResponseCookie {
        return jwtUtils.cleanJwtCookie
    }

    override fun register(userName: String, email: String, password: String) {
        check(userAuthPort.findByEmail(email = email) == null) { throw Exception("Email is already taken!") }
        check(userAuthPort.findByUserName(userName = userName) == null) { throw Exception("Username is already taken!") }

        userAuthPort.save(userName = userName, password = encoder.encode(password), email = email, role = Role.ROLE_USER.name)
    }
}
