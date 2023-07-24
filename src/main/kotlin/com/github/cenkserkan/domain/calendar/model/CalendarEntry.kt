package com.github.cenkserkan.domain.calendar.model

import org.hibernate.validator.constraints.UUID
import java.time.LocalDate
import java.util.UUID as UUIDType

data class CalendarEntry(
    @UUID val id: UUIDType?,
    @UUID val userId: UUIDType,
    val date: LocalDate,
    @UUID val recipeId: UUIDType
)
