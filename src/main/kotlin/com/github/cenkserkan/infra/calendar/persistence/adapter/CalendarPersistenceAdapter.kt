package com.github.cenkserkan.infra.calendar.persistence.adapter

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.infra.calendar.persistence.repository.CalendarRepository
import java.util.UUID

class CalendarPersistenceAdapter(private val calendarRepository: CalendarRepository) : CalendarPort {
    override fun getEntries(userId: UUID): List<CalendarEntry> {
        return calendarRepository.getEntries(userId)
    }

    override fun addEntries(entries: List<CalendarEntry>) {
        calendarRepository.addEntries(entries)
    }
}
