package com.portfolio.eventmanagement.application.web

import com.portfolio.eventmanagement.domain.model.Event
import com.portfolio.eventmanagement.domain.service.EventService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
@Tag(name = "Events", description = "Event management endpoints")
class EventController(private val eventService: EventService) {

    @GetMapping
    suspend fun list() = eventService.getAll()

    @GetMapping("/{id}")
    suspend fun get(@PathVariable id: Long): ResponseEntity<Event> =
        eventService.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(@RequestBody event: Event) = eventService.create(event)

    @PutMapping("/{id}")
    suspend fun update(@PathVariable id: Long, @RequestBody event: Event): ResponseEntity<Event> =
        eventService.update(id, event)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun delete(@PathVariable id: Long) = eventService.delete(id)
}
