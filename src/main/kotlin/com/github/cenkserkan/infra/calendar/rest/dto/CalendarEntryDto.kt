package com.github.cenkserkan.infra.calendar.rest.dto

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import java.time.LocalDate
import java.util.UUID

data class CalendarEntryDto(
    val recipeId: UUID,
    val date: LocalDate
) {
    fun toModel(userId: UUID): CalendarEntry {
        return CalendarEntry(
            userId = userId,
            date = date,
            recipeId = recipeId
        )
    }
}
