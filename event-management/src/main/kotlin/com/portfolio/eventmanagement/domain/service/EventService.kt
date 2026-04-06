package com.portfolio.eventmanagement.domain.service

import com.portfolio.eventmanagement.domain.model.Event
import org.springframework.stereotype.Service

@Service
class EventService {
    private val events = mutableListOf<Event>()

    fun getAll(): List<Event> = events
    fun create(event: Event): Event {
        val newEvent = event.copy(id = (events.size + 1).toLong())
        events.add(newEvent)
        return newEvent
    }
}
