package com.portfolio.eventmanagementadv.domain.repository
import com.portfolio.eventmanagementadv.domain.model.*
interface EventManagementAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}