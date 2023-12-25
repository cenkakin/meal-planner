package com.github.cenkserkan.domain.calendar.usecase

import com.github.cenkserkan.domain.calendar.model.CalendarEntry

interface GetCalendarEntriesUseCase {
    fun getCalendarEntries(email: String): List<CalendarEntry>
}
