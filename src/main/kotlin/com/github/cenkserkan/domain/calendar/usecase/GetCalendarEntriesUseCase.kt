package com.github.cenkserkan.domain.calendar.usecase

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import java.util.UUID

interface GetCalendarEntriesUseCase {
    fun getCalendarEntries(userId: UUID): List<CalendarEntry>
}
