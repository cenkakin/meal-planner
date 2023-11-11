package com.github.cenkserkan.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserAdapter(private val user: User) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return user.authorities.mapTo(
            mutableListOf()
        ) { SimpleGrantedAuthority(it.name) }
    }

    override fun getPassword(): String {
        return requireNotNull(user.password)
    }

    override fun getUsername(): String {
        return requireNotNull(user.userName)
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
