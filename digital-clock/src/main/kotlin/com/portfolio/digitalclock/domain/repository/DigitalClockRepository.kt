package com.portfolio.digitalclock.domain.repository
import com.portfolio.digitalclock.domain.model.*
interface DigitalClockRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}