package com.github.cenkserkan.domain.calendar.usecase

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import java.util.UUID

interface AddCalendarEntryUseCase {
    fun addToCalendar(calendarId: UUID, entry: CalendarEntry)
}