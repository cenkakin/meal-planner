package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import java.time.LocalDate
import java.util.UUID

class CalendarRepository {
    private val userId = UUID.fromString("73f6af82-ab5f-40da-9873-f9dc88129607")
    private val inMemoryCalendarRepository = mutableListOf<CalendarEntry>(

        CalendarEntry(
            UUID.randomUUID(),
            UUID.fromString("73f6af82-ab5f-40da-9873-f9dc88129607"),
            LocalDate.of(2023, 7, 13),
            UUID.fromString("d124d6bb-8cc9-4843-8f48-ee0948042803")
        ),
        CalendarEntry(
            UUID.randomUUID(),
            UUID.fromString("73f6af82-ab5f-40da-9873-f9dc88129607"),
            LocalDate.of(2023, 7, 13),
            UUID.fromString("21ef68f2-7ab5-486a-a1ad-2d7ab05757d4")

        )

    )

    fun addEntries(entries: List<CalendarEntry>) {
        entries.forEach { entry -> inMemoryCalendarRepository.add(entry) }
    }

    fun getEntries(userId: UUID = this.userId): List<CalendarEntry> {
        return inMemoryCalendarRepository.filter { it.userId == userId }
    }
}
