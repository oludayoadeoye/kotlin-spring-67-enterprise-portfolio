package com.portfolio.eventmanagement.domain.service

import com.portfolio.eventmanagement.domain.model.Event
import com.portfolio.eventmanagement.domain.repository.EventRepository
import org.springframework.stereotype.Service

@Service
class EventService(private val repository: EventRepository) {
    suspend fun getAll(): List<Event> = repository.findAll()
    suspend fun getById(id: Long): Event? = repository.findById(id)
    suspend fun create(event: Event): Event = repository.save(event)
    suspend fun update(id: Long, updated: Event): Event? {
        val existing = repository.findById(id) ?: return null
        return repository.save(updated.copy(id = existing.id))
    }
    suspend fun delete(id: Long) = repository.deleteById(id)
}
