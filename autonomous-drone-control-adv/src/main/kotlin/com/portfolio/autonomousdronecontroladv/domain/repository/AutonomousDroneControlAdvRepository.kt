package com.portfolio.autonomousdronecontroladv.domain.repository
import com.portfolio.autonomousdronecontroladv.domain.model.*
interface AutonomousDroneControlAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}