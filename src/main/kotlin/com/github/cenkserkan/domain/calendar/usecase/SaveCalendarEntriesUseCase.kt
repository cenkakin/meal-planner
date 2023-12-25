package com.github.cenkserkan.domain.calendar.usecase

import com.github.cenkserkan.infra.calendar.rest.dto.CalendarEntryDto

interface SaveCalendarEntriesUseCase {
    fun saveCalendarEntries(email: String, entries: List<CalendarEntryDto>)
}
