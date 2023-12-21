package com.github.cenkserkan.domain.calendar.model

import com.github.cenkserkan.infra.calendar.rest.dto.CalendarEntryDto
import java.time.LocalDate
import java.util.UUID

data class CalendarEntry(
    val id: UUID?,
    val userId: UUID,
    val date: LocalDate,
    val recipeId: UUID
) {

    constructor(userId: UUID, date: LocalDate, recipeId: UUID) : this(id = null, userId = userId, date = date, recipeId = recipeId)

    fun toDto(): CalendarEntryDto {
        return CalendarEntryDto(
            recipeId = recipeId,
            date = date
        )
    }
}
