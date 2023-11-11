package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.auth.User
import com.github.cenkserkan.domain.userAuth.model.Role
import com.github.cenkserkan.infra.adapters.generated.Tables.USER
import com.github.cenkserkan.infra.adapters.generated.tables.records.UserRecord
import org.jooq.DSLContext
import java.util.UUID

class UserRepository(private val dslContext: DSLContext) {

    fun findUserById(id: UUID): User? {
        return dslContext.select(USER.ID, USER.USER_NAME, USER.PASSWORD, USER.EMAIL, USER.ROLES)
            .from(USER)
            .where(USER.ID.eq(id))
            .fetchOne()
            ?.into(User::class.java)
    }

    fun findUserByEmail(email: String): User? {
        return dslContext.select(USER.ID, USER.USER_NAME, USER.PASSWORD, USER.EMAIL, USER.ROLES)
            .from(USER)
            .where(USER.EMAIL.eq(email))
            .fetchOne()
            ?.into(User::class.java)
    }

    fun saveUser(user: User): User {
        return dslContext.insertInto(USER)
            .columns(USER.USER_NAME, USER.PASSWORD, USER.EMAIL, USER.ROLES)
            .values(user.userName, user.password, user.email, user.authorities.map { it.name }.toTypedArray())
            .returning()
            .fetch()
            .single()
            .toUser()
    }

    fun findUserByUserName(userName: String): User? {
        return dslContext.select(USER.ID, USER.USER_NAME, USER.PASSWORD, USER.EMAIL, USER.ROLES)
            .from(USER)
            .where(USER.USER_NAME.eq(userName))
            .fetchOne()
            ?.into(User::class.java)
    }
}

private fun UserRecord.toUser(): User {
    return User(
        userName = this.userName,
        password = this.password,
        email = this.email,
        authorities = this.roles.map { Role.valueOf(it) }
    )
}
