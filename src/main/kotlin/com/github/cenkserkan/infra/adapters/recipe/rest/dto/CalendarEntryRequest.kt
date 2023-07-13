package com.github.cenkserkan.infra.adapters.recipe.rest.dto

import com.github.cenkserkan.domain.calendar.model.CalendarEntry
import org.hibernate.validator.constraints.UUID
import java.util.UUID as UUIDType

data class CalendarEntryRequest(@UUID val calendarId: UUIDType, val entry: CalendarEntry)