package com.github.cenkserkan.domain.calendar.handler

import com.github.cenkserkan.auth.UserNotFoundException
import com.github.cenkserkan.auth.UserPort
import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.domain.calendar.usecase.GetCalendarEntriesUseCase
import com.github.cenkserkan.domain.calendar.usecase.RecipeLimitExceededException
import com.github.cenkserkan.domain.calendar.usecase.SaveCalendarEntriesUseCase
import com.github.cenkserkan.infra.calendar.rest.dto.CalendarEntryDto
import org.springframework.security.core.userdetails.UserDetails

class CalendarHandler(
    private val calendarPort: CalendarPort,
    private val userPort: UserPort
) : SaveCalendarEntriesUseCase, GetCalendarEntriesUseCase {
    override fun saveCalendarEntries(userDetails: UserDetails, entries: List<CalendarEntryDto>) {
        check(entries.size <= 3) { throw RecipeLimitExceededException() }

        val email = userDetails.username

        with(requireNotNull(userPort.findByEmail(email)?.id) { throw UserNotFoundException(email) }) {
            calendarPort.addEntries(
                entries = entries.map {
                    it.toModel(this)
                }
            )
        }
    }

    override fun getCalendarEntries(userDetails: UserDetails): List<CalendarEntry> {
        val email = userDetails.username

        return with(requireNotNull(userPort.findByEmail(email)?.id) { throw UserNotFoundException(email) }) {
            calendarPort.getEntries(userId = this)
        }
    }
}
