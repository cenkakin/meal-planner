package com.github.cenkserkan.domain.calendar.handler

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.domain.calendar.usecase.GetCalendarEntriesUseCase
import com.github.cenkserkan.domain.calendar.usecase.RecipeLimitExceededException
import com.github.cenkserkan.domain.calendar.usecase.SaveCalendarEntriesUseCase
import java.util.UUID

class CalendarHandler(private val calendarPort: CalendarPort) : SaveCalendarEntriesUseCase, GetCalendarEntriesUseCase {
    override fun saveCalendarEntries(entries: List<CalendarEntry>) {
        check(entries.size <= 3) { throw RecipeLimitExceededException() }
        calendarPort.addEntries(entries = entries)
    }

    override fun getCalendarEntries(userId: UUID): List<CalendarEntry> {
        return calendarPort.getEntries(userId = userId)
    }
}
