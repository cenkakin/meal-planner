package com.github.cenkserkan.domain.calendar.model

import java.time.LocalDate
import java.util.UUID
import com.github.cenkserkan.infra.calendar.rest.dto.CalendarEntryDto

data class CalendarEntry(
    var id: UUID?,
    val userId: UUID,
    val date: LocalDate,
    val recipeId: UUID
) {
    fun toDto(): CalendarEntryDto {
        return CalendarEntryDto(
            userId = userId,
            recipeId = recipeId,
            date = date
        )
    }
}
