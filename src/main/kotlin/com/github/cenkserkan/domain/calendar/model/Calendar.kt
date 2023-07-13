package com.github.cenkserkan.domain.calendar.model

import java.util.UUID

data class Calendar(val id: UUID, val entries: List<CalendarEntry>)