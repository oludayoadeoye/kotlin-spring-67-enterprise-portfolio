package com.portfolio.smarthomesecuritysystem.domain.repository
import com.portfolio.smarthomesecuritysystem.domain.model.*
interface SmartHomeSecuritySystemRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}