package com.github.cenkserkan.infra.adapters.recipe.rest.controller

import com.github.cenkserkan.domain.calendar.usecase.GetCalendarEntriesUseCase
import com.github.cenkserkan.domain.calendar.usecase.RecipeLimitExceededException
import com.github.cenkserkan.domain.calendar.usecase.SaveCalendarEntriesUseCase
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.CalendarEntryListResponse
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.CalendarEntryRequest
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.CalendarEntryResponse
import jakarta.validation.constraints.NotEmpty
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1/calendar")
class CalendarController(
    private val addCalendarEntryUseCase: SaveCalendarEntriesUseCase,
    private val getCalendarEntriesUseCase: GetCalendarEntriesUseCase
) {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{userId}")
    fun getCalendarEntries(
        @PathVariable @NotEmpty
        userId: UUID
    ): ResponseEntity<CalendarEntryListResponse> {
        val calendarEntries = getCalendarEntriesUseCase.getCalendarEntries(userId = userId)
            .map { CalendarEntryResponse.from(it) }
        return ResponseEntity.ok(CalendarEntryListResponse(calendarEntries))
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    fun addCalendarEntries(@RequestBody request: CalendarEntryRequest): ResponseEntity<String> {
        try {
            addCalendarEntryUseCase.saveCalendarEntries(entries = request.entries)
        } catch (exception: RecipeLimitExceededException) {
            return ResponseEntity.internalServerError().body(exception.message)
        }
        return ResponseEntity.ok("Entry added to calendar")
    }
}
