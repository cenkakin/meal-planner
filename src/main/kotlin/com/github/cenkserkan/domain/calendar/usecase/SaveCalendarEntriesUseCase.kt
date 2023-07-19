package com.github.cenkserkan.domain.calendar.usecase

import com.github.cenkserkan.domain.calendar.model.CalendarEntry

interface SaveCalendarEntriesUseCase {
    fun saveCalendarEntries(entries: List<CalendarEntry>)
}
