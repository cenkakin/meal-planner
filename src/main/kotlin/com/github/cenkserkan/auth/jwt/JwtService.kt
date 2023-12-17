package com.github.cenkserkan.auth.jwt

import com.github.cenkserkan.auth.model.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.impl.security.StandardSecureDigestAlgorithms
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import java.util.Date

class JwtService(
    private val secretKey: String,
    private val expirationMs: Long
) {

    fun extractUsername(token: String): String? {
        return extractClaim(token, Claims::getSubject)
    }

    fun isTokenValid(token: String, user: User): Boolean {
        val userName = extractUsername(token)

        return userName == user.email && !isTokenExpired(token)
    }

    private fun <T> extractClaim(token: String, claimsResolver: Claims.() -> T): T {
        val claims = extractAllClaims(token)

        return claimsResolver(claims)
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractClaim(token, Claims::getExpiration).before(Date())
    }

    fun generateToken(extraClaims: Map<String, Any>? = null, user: User): String =
        Jwts.builder()
            .claims(extraClaims)
            .subject(user.email)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(Date(System.currentTimeMillis() + expirationMs))
            .signWith(getSigningKey(), StandardSecureDigestAlgorithms.findBySigningKey(getSigningKey()))
            .compact()

    private fun extractAllClaims(token: String): Claims {
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).payload
    }

    private fun getSigningKey() = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))
}
