package com.github.cenkserkan.infra.adapters.recipe.persistence

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.CalendarRepository
import java.util.UUID

class CalendarPersistenceAdapter(private val calendarRepository: CalendarRepository): CalendarPort {
    override fun getEntries(calendarId: UUID): List<CalendarEntry> {
        return calendarRepository.getEntries()
    }

    override fun addEntry(calendarId: UUID, entry: CalendarEntry) {
        calendarRepository.addEntry(entry = entry)
    }
}