package com.github.cenkserkan.domain.calendar.port

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import java.util.UUID

interface CalendarPort {

    fun getEntries(userId: UUID): List<CalendarEntry>

    fun addEntries(entries: List<CalendarEntry>)
}
