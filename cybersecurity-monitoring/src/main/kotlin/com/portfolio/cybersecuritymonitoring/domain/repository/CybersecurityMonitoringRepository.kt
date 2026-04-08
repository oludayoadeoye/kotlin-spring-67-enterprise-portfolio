package com.portfolio.cybersecuritymonitoring.domain.repository
import com.portfolio.cybersecuritymonitoring.domain.model.*
interface CybersecurityMonitoringRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}