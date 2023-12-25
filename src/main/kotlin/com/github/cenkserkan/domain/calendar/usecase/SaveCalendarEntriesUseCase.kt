package com.github.cenkserkan.domain.calendar.usecase

import com.github.cenkserkan.infra.calendar.rest.dto.CalendarEntryDto
import org.springframework.security.core.userdetails.UserDetails

interface SaveCalendarEntriesUseCase {
    fun saveCalendarEntries(userDetails: UserDetails, entries: List<CalendarEntryDto>)
}
