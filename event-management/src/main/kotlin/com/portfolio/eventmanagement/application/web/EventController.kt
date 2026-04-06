package com.portfolio.eventmanagement.application.web

import com.portfolio.eventmanagement.domain.model.Event
import com.portfolio.eventmanagement.domain.service.EventService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
class EventController(private val eventService: EventService) {
    @GetMapping fun list() = eventService.getAll()
    @PostMapping fun create(@RequestBody event: Event) = eventService.create(event)
}
