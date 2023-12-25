package com.github.cenkserkan.domain.calendar.handler

import com.github.cenkserkan.auth.UserPort
import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.domain.calendar.usecase.GetCalendarEntriesUseCase
import com.github.cenkserkan.domain.calendar.usecase.RecipeLimitExceededException
import com.github.cenkserkan.domain.calendar.usecase.SaveCalendarEntriesUseCase
import com.github.cenkserkan.infra.calendar.rest.dto.CalendarEntryDto

class CalendarHandler(
    private val calendarPort: CalendarPort,
    private val userPort: UserPort
) : SaveCalendarEntriesUseCase, GetCalendarEntriesUseCase {
    override fun saveCalendarEntries(email: String, entries: List<CalendarEntryDto>) {
        check(entries.size <= 3) { throw RecipeLimitExceededException() }

        val user = userPort.findByEmailOrThrow(email)
        calendarPort.addEntries(
            entries = entries.map {
                it.toModel(user.id!!)
            }
        )
    }

    override fun getCalendarEntries(email: String): List<CalendarEntry> {
        val user = userPort.findByEmailOrThrow(email)
        return calendarPort.getEntries(user.id!!)
    }
}
