package com.github.cenkserkan.domain.calendar.model

import java.time.LocalDate
import java.util.UUID

data class CalendarEntry(val date: LocalDate, val savedRecipes: List<UUID>)
