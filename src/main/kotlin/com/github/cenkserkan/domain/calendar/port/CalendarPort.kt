package com.github.cenkserkan.domain.calendar.port

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import java.util.UUID

interface CalendarPort {

    fun getEntries(calendarId: UUID): List<CalendarEntry>

    fun addEntry(calendarId: UUID, entry: CalendarEntry)
}
