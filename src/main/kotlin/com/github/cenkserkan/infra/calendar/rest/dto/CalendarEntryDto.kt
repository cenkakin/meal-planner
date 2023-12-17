package com.github.cenkserkan.infra.calendar.rest.dto

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import java.time.LocalDate
import java.util.UUID

data class CalendarEntryDto(
    val userId: UUID,
    val recipeId: UUID,
    val date: LocalDate
) {
    fun toModel(): CalendarEntry {
        return CalendarEntry(
            id = null,
            userId = userId,
            date = date,
            recipeId = recipeId
        )
    }
}
