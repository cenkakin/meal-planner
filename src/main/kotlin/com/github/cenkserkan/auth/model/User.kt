package com.github.cenkserkan.auth.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class User(
    private val username: String,
    private val password: String,
    val email: String,
    private val authorities: List<Role>
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorities.mapTo(
            mutableListOf()
        ) { SimpleGrantedAuthority(it.name) }
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
