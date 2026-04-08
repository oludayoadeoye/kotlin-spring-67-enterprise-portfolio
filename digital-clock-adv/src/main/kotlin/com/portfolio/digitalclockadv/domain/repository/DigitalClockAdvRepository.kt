package com.portfolio.digitalclockadv.domain.repository
import com.portfolio.digitalclockadv.domain.model.*
interface DigitalClockAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}