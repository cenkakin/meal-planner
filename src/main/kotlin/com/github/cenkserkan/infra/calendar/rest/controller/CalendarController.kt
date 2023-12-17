package com.github.cenkserkan.infra.calendar.rest.controller

import com.github.cenkserkan.domain.calendar.usecase.GetCalendarEntriesUseCase
import com.github.cenkserkan.domain.calendar.usecase.SaveCalendarEntriesUseCase
import com.github.cenkserkan.infra.calendar.rest.dto.CalendarEntriesWrapper
import jakarta.validation.constraints.NotEmpty
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.naming.LimitExceededException

@RestController
@RequestMapping("/v1/calendar")
class CalendarController(
    private val addCalendarEntryUseCase: SaveCalendarEntriesUseCase,
    private val getCalendarEntriesUseCase: GetCalendarEntriesUseCase
) {

    @GetMapping("/{userId}")
    fun getCalendarEntries(
        @PathVariable @NotEmpty
        userId: UUID
    ): ResponseEntity<CalendarEntriesWrapper> {
        val calendarEntries = getCalendarEntriesUseCase.getCalendarEntries(userId = userId)
            .map { it.toDto() }
        return ResponseEntity.ok(CalendarEntriesWrapper(calendarEntries))
    }

    @PostMapping
    fun addCalendarEntries(@RequestBody request: CalendarEntriesWrapper): ResponseEntity<String> {
        try {
            addCalendarEntryUseCase.saveCalendarEntries(request.entries.map { it.toModel() })
        } catch (exception: LimitExceededException) {
            return ResponseEntity.internalServerError().body(exception.message)
        }
        return ResponseEntity.ok("Entry added to calendar")
    }
}
