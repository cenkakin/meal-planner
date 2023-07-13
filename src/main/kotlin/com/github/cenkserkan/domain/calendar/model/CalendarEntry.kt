package com.github.cenkserkan.domain.calendar.model

import com.github.cenkserkan.domain.recipe.model.Recipe
import java.time.LocalDate
import java.util.UUID

data class CalendarEntry(val date: LocalDate, val savedRecipes: List<UUID>)