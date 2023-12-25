package app.domain.handler

import com.github.cenkserkan.auth.AuthUsecase
import com.github.cenkserkan.auth.UserPort
import com.github.cenkserkan.auth.jwt.JwtService
import com.github.cenkserkan.auth.model.User
import com.github.cenkserkan.domain.common.BusinessValidationException
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder

class AuthHandler(
    private val userPort: UserPort,
    private val encoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) : AuthUsecase {
    override fun register(user: User): String {
        check(userPort.findByEmail(user.email) == null) {
            throw BusinessValidationException("User already exists!")
        }

        userPort.save(user = user.copy(password = encoder.encode(user.password)))

        return jwtService.generateToken(user = user)
    }

    override fun login(email: String, password: String): String {
        val user = userPort.findByEmailOrThrow(email)

        val authenticationRequest =
            UsernamePasswordAuthenticationToken.unauthenticated(
                email,
                password
            )

        authenticationManager.authenticate(authenticationRequest)

        return jwtService.generateToken(user = user)
    }

    override fun logout() {
        TODO("NOT YET")
    }
}
