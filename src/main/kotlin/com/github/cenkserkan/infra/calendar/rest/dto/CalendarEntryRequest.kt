package com.github.cenkserkan.infra.calendar.rest.dto

import com.github.cenkserkan.domain.calendar.model.CalendarEntry

data class CalendarEntryRequest(val entries: List<CalendarEntry>)
