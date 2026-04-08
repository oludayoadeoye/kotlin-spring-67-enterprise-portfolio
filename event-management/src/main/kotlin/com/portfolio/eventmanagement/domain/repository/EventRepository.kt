package com.portfolio.eventmanagement.domain.repository

import com.portfolio.eventmanagement.domain.model.Event

interface EventRepository {
    suspend fun findAll(): List<Event>
    suspend fun findById(id: Long): Event?
    suspend fun save(event: Event): Event
    suspend fun deleteById(id: Long)
}
