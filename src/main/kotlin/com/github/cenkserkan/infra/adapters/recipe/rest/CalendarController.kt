package com.github.cenkserkan.infra.adapters.recipe.rest

import com.github.cenkserkan.domain.calendar.usecase.AddCalendarEntryUseCase
import com.github.cenkserkan.domain.calendar.usecase.GetCalendarEntriesUseCase
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.CalendarEntryRequest
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.CalendarEntryListResponse
import com.github.cenkserkan.infra.adapters.recipe.rest.dto.CalendarEntryResponse
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
    private val addCalendarEntryUseCase: AddCalendarEntryUseCase,
    private val getCalendarEntriesUseCase: GetCalendarEntriesUseCase,
) {
    @GetMapping("/{calendarId}")
    fun getCalendarEntries(@PathVariable @NotEmpty calendarId:UUID): ResponseEntity<CalendarEntryListResponse> {
        val calendarEntries = getCalendarEntriesUseCase.getCalendarEntries(calendarId = calendarId)
            .map { CalendarEntryResponse.from(it) }
        return ResponseEntity.ok(CalendarEntryListResponse(calendarEntries))
    }

    @PostMapping
    fun addCalendarEntry(@RequestBody request: CalendarEntryRequest): ResponseEntity<String>{
        try {
            addCalendarEntryUseCase.addToCalendar(calendarId = request.calendarId, entry = request.entry )
        } catch (exception: LimitExceededException){
            return ResponseEntity.internalServerError().body(exception.message)
        }
        return ResponseEntity.ok("Entry added to calendar")
    }
}
