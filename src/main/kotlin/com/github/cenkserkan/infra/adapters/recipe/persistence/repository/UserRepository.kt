package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.userAuth.model.User
import com.github.cenkserkan.infra.adapters.generated.Tables.USER
import com.github.cenkserkan.infra.adapters.generated.tables.records.UserRecord
import org.jooq.DSLContext
import java.util.UUID

class UserRepository(private val dslContext: DSLContext) {

    fun findUserById(id: UUID): User? {
        return dslContext.select(USER.ID, USER.USER_NAME, USER.PASSWORD, USER.EMAIL, USER.ROLE)
            .from(USER)
            .where(USER.ID.eq(id))
            .fetchOne()
            ?.into(User::class.java)
    }

    fun findUserByEmail(email: String): User? {
        return dslContext.select(USER.ID, USER.USER_NAME, USER.PASSWORD, USER.EMAIL, USER.ROLE)
            .from(USER)
            .where(USER.EMAIL.eq(email))
            .fetchOne()
            ?.into(User::class.java)
    }

    fun saveUser(userName: String, password: String, email: String, role: String): User {
        return dslContext.insertInto(USER)
            .columns(USER.USER_NAME, USER.PASSWORD, USER.EMAIL, USER.ROLE)
            .values(userName, password, email, role)
            .returning()
            .fetch()
            .single()
            .toUser()
    }

    fun findUserByUserName(userName: String): User? {
        return dslContext.select(USER.ID, USER.USER_NAME, USER.PASSWORD, USER.EMAIL, USER.ROLE)
            .from(USER)
            .where(USER.USER_NAME.eq(userName))
            .fetchOne()
            ?.into(User::class.java)
    }
}

private fun UserRecord.toUser(): User {
    return User(id = this.id, userName = this.userName, password = this.password, email = this.email, role = this.role)
}
