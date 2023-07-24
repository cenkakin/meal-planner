package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.infra.adapters.generated.Tables.CALENDAR
import org.jooq.DSLContext
import java.util.UUID

class CalendarRepository(private val dslContext: DSLContext) {

    fun addEntries(entries: List<CalendarEntry>) {
        val insertStep = dslContext.insertInto(CALENDAR)
            .columns(CALENDAR.USER_ID, CALENDAR.DATE, CALENDAR.RECIPE_ID)
        entries.map {
            insertStep.values(it.userId, it.date, it.recipeId)
        }
        insertStep
            .returning()
            .fetch()
    }

    fun getEntries(userId: UUID): List<CalendarEntry> {
        return dslContext.selectFrom(CALENDAR)
            .where(CALENDAR.USER_ID.eq(userId))
            .fetchInto(CalendarEntry::class.java)
    }
}
