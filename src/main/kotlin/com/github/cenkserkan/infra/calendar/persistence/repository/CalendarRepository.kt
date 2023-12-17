package com.github.cenkserkan.infra.calendar.persistence.repository

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.infra.adapters.generated.Tables
import com.github.cenkserkan.infra.adapters.generated.tables.records.CalendarRecord
import org.jooq.DSLContext
import org.jooq.exception.DataAccessException
import java.util.UUID

class CalendarRepository(private val dslContext: DSLContext) {
    private val calendarTable = Tables.CALENDAR

    fun addEntries(entries: List<CalendarEntry>): List<CalendarEntry> {
        return try {
            dslContext.transactionResult { config ->
                val context = config.dsl()

                entries.map { entry ->
                    context
                        .insertInto(calendarTable)
                        .columns(calendarTable.USER_ID, calendarTable.RECIPE_ID, calendarTable.DATE)
                        .values(entry.userId, entry.recipeId, entry.date)
                        .returning(calendarTable.ID, calendarTable.USER_ID, calendarTable.RECIPE_ID, calendarTable.DATE)
                        .fetchSingle()
                        .toCalendarEntry()
                }
            }
        } catch (exception: RuntimeException) {
            when (exception) {
                is DataAccessException -> TODO()
                else -> TODO()
            }
        }
    }

    fun getEntries(userId: UUID): List<CalendarEntry> {
        return dslContext
            .selectFrom(calendarTable)
            .where(calendarTable.USER_ID.eq(userId))
            .fetch()
            .map {
                it.toCalendarEntry()
            }
    }
}

private fun CalendarRecord.toCalendarEntry(): CalendarEntry {
    return CalendarEntry(id = this.id, userId = this.userId, date = this.date, recipeId = this.recipeId)
}
