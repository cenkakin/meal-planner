package com.github.cenkserkan.domain.calendar.model

import org.hibernate.validator.constraints.UUID
import java.time.LocalDate
import java.util.UUID as UUIDType

data class CalendarEntry(
    @UUID val id: UUIDType = UUIDType.randomUUID(),
    @UUID val userId: UUIDType = UUIDType.fromString("73f6af82-ab5f-40da-9873-f9dc88129607"),
    val date: LocalDate,
    @UUID val recipeId: UUIDType
)
