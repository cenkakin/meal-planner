package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.auth.model.Role
import com.github.cenkserkan.auth.model.User
import com.github.cenkserkan.infra.adapters.generated.Tables.USER
import com.github.cenkserkan.infra.adapters.generated.tables.records.UserRecord
import org.jooq.DSLContext
import org.jooq.Record4
import java.util.UUID

class UserRepository(private val dslContext: DSLContext) {

    fun findUserById(id: UUID): User? {
        return dslContext.select(USER.USERNAME, USER.PASSWORD, USER.EMAIL, USER.ROLES)
            .from(USER)
            .where(USER.ID.eq(id))
            .fetch()
            .singleOrNull()
            .toUser()
    }

    fun findUserByEmail(email: String): User? {
        return dslContext.select(USER.USERNAME, USER.PASSWORD, USER.EMAIL, USER.ROLES)
            .from(USER)
            .where(USER.EMAIL.eq(email))
            .fetch()
            .singleOrNull()
            .toUser()
    }

    fun saveUser(user: User): User {
        return dslContext.insertInto(USER)
            .columns(USER.USERNAME, USER.PASSWORD, USER.EMAIL, USER.ROLES)
            .values(user.username, user.password, user.email, user.authorities.map { it.authority }.toTypedArray())
            .returning()
            .fetchSingle()
            .toUser()
    }

    fun findUserByUserName(userName: String): User? {
        return dslContext.select(USER.USERNAME, USER.PASSWORD, USER.EMAIL, USER.ROLES)
            .from(USER)
            .where(USER.USERNAME.eq(userName))
            .fetch()
            .singleOrNull()
            .toUser()
    }
}

private fun Record4<String, String, String, Array<String>>?.toUser(): User? {
    return if (this != null) {
        User(
            username = this.component1(),
            password = this.component2(),
            email = this.component3(),
            authorities = this.component4().map { Role.valueOf(it) }
        )
    } else {
        null
    }
}

private fun UserRecord.toUser(): User {
    return User(
        username = this.username,
        password = this.password,
        email = this.email,
        authorities = this.roles.map { Role.valueOf(it) }
    )
}
