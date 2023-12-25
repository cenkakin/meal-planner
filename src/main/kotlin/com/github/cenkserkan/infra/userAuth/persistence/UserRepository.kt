package com.github.cenkserkan.infra.userAuth.persistence

import com.github.cenkserkan.auth.model.Role
import com.github.cenkserkan.auth.model.User
import com.github.cenkserkan.infra.adapters.generated.Tables
import com.github.cenkserkan.infra.adapters.generated.tables.records.UserRecord
import org.jooq.DSLContext
import org.jooq.Record5
import java.util.UUID

class UserRepository(private val dslContext: DSLContext) {

    fun findUserById(id: UUID): User? {
        return dslContext.select(Tables.USER.USERNAME, Tables.USER.PASSWORD, Tables.USER.EMAIL, Tables.USER.ROLES, Tables.USER.ID)
            .from(Tables.USER)
            .where(Tables.USER.ID.eq(id))
            .fetch()
            .singleOrNull()
            .toUser()
    }

    fun findUserByEmail(email: String): User? {
        return dslContext.select(Tables.USER.USERNAME, Tables.USER.PASSWORD, Tables.USER.EMAIL, Tables.USER.ROLES, Tables.USER.ID)
            .from(Tables.USER)
            .where(Tables.USER.EMAIL.eq(email))
            .fetch()
            .singleOrNull()
            .toUser()
    }

    fun saveUser(user: User): User {
        return dslContext.insertInto(Tables.USER)
            .columns(Tables.USER.USERNAME, Tables.USER.PASSWORD, Tables.USER.EMAIL, Tables.USER.ROLES)
            .values(user.username, user.password, user.email, user.authorities.map { it.authority }.toTypedArray())
            .returning()
            .fetchSingle()
            .toUser()
    }

    fun findUserByUserName(userName: String): User? {
        return dslContext.select(Tables.USER.USERNAME, Tables.USER.PASSWORD, Tables.USER.EMAIL, Tables.USER.ROLES, Tables.USER.ID)
            .from(Tables.USER)
            .where(Tables.USER.USERNAME.eq(userName))
            .fetch()
            .singleOrNull()
            .toUser()
    }
}

private fun Record5<String, String, String, Array<String>, UUID>?.toUser(): User? {
    return if (this != null) {
        User(
            id = this.component5(),
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
        id = this.id,
        username = this.username,
        password = this.password,
        email = this.email,
        authorities = this.roles.map { Role.valueOf(it) }
    )
}
