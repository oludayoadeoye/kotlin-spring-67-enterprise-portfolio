package com.portfolio.cybersecuritymonitoringadv.domain.repository
import com.portfolio.cybersecuritymonitoringadv.domain.model.*
interface CybersecurityMonitoringAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}