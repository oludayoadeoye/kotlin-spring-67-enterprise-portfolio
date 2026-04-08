package com.portfolio.smarthomesecurity.domain.repository
import com.portfolio.smarthomesecurity.domain.model.*
interface SmartHomeSecurityRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}