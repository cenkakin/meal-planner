package com.github.cenkserkan.domain.calendar.handler

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.domain.calendar.usecase.AddCalendarEntryUseCase
import com.github.cenkserkan.domain.calendar.usecase.GetCalendarEntriesUseCase
import java.util.UUID

class CalendarHandler(private val calendarPort: CalendarPort) : AddCalendarEntryUseCase, GetCalendarEntriesUseCase {
    override fun addToCalendar(calendarId: UUID, entry: CalendarEntry) {
        calendarPort.addEntry(calendarId = calendarId, entry = entry)
    }

    override fun getCalendarEntries(calendarId: UUID): List<CalendarEntry> {
        return calendarPort.getEntries(calendarId = calendarId)
    }
}
