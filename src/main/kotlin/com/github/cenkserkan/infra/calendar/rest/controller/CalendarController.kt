package com.github.cenkserkan.infra.calendar.rest.controller

import com.github.cenkserkan.domain.calendar.usecase.GetCalendarEntriesUseCase
import com.github.cenkserkan.domain.calendar.usecase.SaveCalendarEntriesUseCase
import com.github.cenkserkan.infra.calendar.rest.dto.CalendarEntriesWrapper
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.naming.LimitExceededException

@RestController
@RequestMapping("/v1/calendar")
class CalendarController(
    private val addCalendarEntryUseCase: SaveCalendarEntriesUseCase,
    private val getCalendarEntriesUseCase: GetCalendarEntriesUseCase
) {

    @GetMapping
    fun getCalendarEntries(@AuthenticationPrincipal userDetails: UserDetails): ResponseEntity<CalendarEntriesWrapper> {
        val calendarEntries = getCalendarEntriesUseCase.getCalendarEntries(userDetails.username)
            .map { it.toDto() }
        return ResponseEntity.ok(CalendarEntriesWrapper(calendarEntries))
    }

    @PostMapping
    fun addCalendarEntries(
        @RequestBody request: CalendarEntriesWrapper,
        @AuthenticationPrincipal userDetails: UserDetails
    ): ResponseEntity<String> {
        try {
            addCalendarEntryUseCase.saveCalendarEntries(userDetails.username, request.entries)
        } catch (exception: LimitExceededException) {
            return ResponseEntity.internalServerError().body(exception.message)
        }
        return ResponseEntity.ok("Entry added to calendar")
    }
}
