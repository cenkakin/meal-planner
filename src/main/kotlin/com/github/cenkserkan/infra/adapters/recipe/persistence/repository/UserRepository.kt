package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.user.model.User
import com.github.cenkserkan.infra.adapters.generated.Tables.USER
import org.jooq.DSLContext
import org.jooq.Record4
import java.util.UUID

class UserRepository(private val dslContext: DSLContext) {

    fun getUserById(id: UUID): User? {
        return dslContext.select(USER.ID, USER.USER_NAME, USER.PASSWORD, USER.EMAIL)
            .from(USER)
            .where(USER.ID.eq(id))
            .fetchOne()
            ?.toUser()
    }
}

private fun Record4<UUID, String, String, String>.toUser(): User = User(
    id = this.component1(),
    userName = this.component2(),
    password = this.component3(),
    email = this.component4()
)
