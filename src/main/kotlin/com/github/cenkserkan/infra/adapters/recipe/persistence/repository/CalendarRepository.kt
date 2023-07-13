package com.github.cenkserkan.infra.adapters.recipe.persistence.repository

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import com.github.cenkserkan.domain.calendar.usecase.RecipeLimitExceededException
import com.github.cenkserkan.domain.common.BusinessValidationException
import java.time.LocalDate
import java.util.UUID

class CalendarRepository {
    private val calendarId = UUID.fromString("73f6af82-ab5f-40da-9873-f9dc88129607")
    private val inMemoryCalendarRepository = mutableMapOf<UUID, List<CalendarEntry>>(
        calendarId to listOf(
            CalendarEntry(
                LocalDate.of(2023, 7, 13),
                listOf(
                    UUID.fromString("900bd2c8-6502-400e-9135-049fbc9b0892"),
                    UUID.fromString("d124d6bb-8cc9-4843-8f48-ee0948042803")
                )
            )
        )
    )

    fun addEntry(calendarId: UUID = this.calendarId, entry: CalendarEntry) {
        if (inMemoryCalendarRepository[calendarId] == null) {
            inMemoryCalendarRepository[calendarId] = listOf(entry)
            return
        }

        val existingEntry = inMemoryCalendarRepository[calendarId]
            ?.firstOrNull { it.date == entry.date }

        if (existingEntry?.savedRecipes != null) {
            check(existingEntry.savedRecipes.size < 3) { throw RecipeLimitExceededException() }
            check(!existingEntry.savedRecipes.containsAll(entry.savedRecipes)) { throw BusinessValidationException("Recipe already exists!") }
            inMemoryCalendarRepository[calendarId] = listOf(
                CalendarEntry(
                    date = existingEntry.date,
                    savedRecipes = existingEntry.savedRecipes.union(entry.savedRecipes).toList()
                )
            )
        } else {
            inMemoryCalendarRepository[calendarId] = listOf(entry)
        }
    }

    fun getEntries(calendarId: UUID = this.calendarId): List<CalendarEntry> {
        return inMemoryCalendarRepository[calendarId] ?: emptyList()
    }
}
