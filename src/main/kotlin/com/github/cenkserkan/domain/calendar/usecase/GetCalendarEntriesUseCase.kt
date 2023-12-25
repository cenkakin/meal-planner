package com.github.cenkserkan.domain.calendar.usecase

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import org.springframework.security.core.userdetails.UserDetails

interface GetCalendarEntriesUseCase {
    fun getCalendarEntries(userDetails: UserDetails): List<CalendarEntry>
}
