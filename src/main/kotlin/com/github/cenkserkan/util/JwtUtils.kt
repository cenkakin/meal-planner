package com.github.cenkserkan.util

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseCookie
import org.springframework.security.core.userdetails.User
import org.springframework.web.util.WebUtils
import java.security.Key
import java.util.Date

class JwtUtils(
    private val jwtSecret: String,
    private val jwtExpirationMs: Long,
    private val jwtCookie: String
) {
    fun getJwtFromCookies(request: HttpServletRequest): String? {
        val cookie = WebUtils.getCookie(request, jwtCookie)
        return cookie?.value
    }

    fun generateJwtCookie(userPrincipal: User): ResponseCookie {
        val jwt = generateTokenFromUsername(userPrincipal.username)
        return ResponseCookie.from(jwtCookie, jwt).path("/v1").maxAge((24 * 60 * 60).toLong()).httpOnly(true)
            .build()
    }

    val cleanJwtCookie: ResponseCookie
        get() = ResponseCookie.from(jwtCookie, "").path("/v1").build()

    fun getUserNameFromJwtToken(token: String): String {
        return Jwts.parserBuilder().setSigningKey(key()).build()
            .parseClaimsJws(token).body.subject
    }

    private fun key(): Key {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret))
    }

    fun validateJwtToken(authToken: String): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken)
            return true
        } catch (e: MalformedJwtException) {
            logger.error("Invalid JWT token: {}", e.message)
        } catch (e: ExpiredJwtException) {
            logger.error("JWT token is expired: {}", e.message)
        } catch (e: UnsupportedJwtException) {
            logger.error("JWT token is unsupported: {}", e.message)
        } catch (e: IllegalArgumentException) {
            logger.error("JWT claims string is empty: {}", e.message)
        }
        return false
    }

    fun generateTokenFromUsername(userName: String): String {
        return Jwts.builder()
            .setSubject(userName)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().time + jwtExpirationMs))
            .signWith(key(), SignatureAlgorithm.HS256)
            .compact()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(JwtUtils::class.java)
    }
}
