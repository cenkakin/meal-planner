package com.github.cenkserkan.infra.calendar.rest.dto

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import java.time.LocalDate
import java.util.UUID

data class CalendarEntryResponse(
    val date: LocalDate,
    val recipeId: UUID
) {
    companion object {
        fun from(entry: CalendarEntry): CalendarEntryResponse {
            return CalendarEntryResponse(
                date = entry.date,
                recipeId = entry.recipeId
            )
        }
    }
}
