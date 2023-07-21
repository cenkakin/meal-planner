package com.github.cenkserkan.infra.adapters.recipe.persistence.adapter

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.domain.calendar.port.CalendarPort
import com.github.cenkserkan.infra.adapters.recipe.persistence.repository.CalendarRepository
import java.util.UUID

class CalendarPersistenceAdapter(private val calendarRepository: CalendarRepository) : CalendarPort {
    override fun getEntries(userId: UUID): List<CalendarEntry> {
        return calendarRepository.getEntries()
    }

    override fun addEntries(entries: List<CalendarEntry>) {
        calendarRepository.addEntries(entries = entries)
    }
}
