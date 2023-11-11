package app.domain.handler

import com.github.cenkserkan.auth.User
import com.github.cenkserkan.auth.UserPort
import com.github.cenkserkan.domain.common.BusinessValidationException
import org.springframework.http.ResponseCookie
import org.springframework.security.crypto.password.PasswordEncoder

class AuthHandler(
    private val userPort: UserPort,
    private val encoder: PasswordEncoder
) {
    fun register(user: User) {
        check(userPort.findByEmail(email = user.email) == null) { throw BusinessValidationException("User already exists!") }

        userPort.save(user = user.copy(password = encoder.encode(user.password)))
    }

    fun login(email: String, password: String): User {
        TODO("NOT YET")
    }

    fun logout(): ResponseCookie {
        TODO("NOT YET")
    }
}
