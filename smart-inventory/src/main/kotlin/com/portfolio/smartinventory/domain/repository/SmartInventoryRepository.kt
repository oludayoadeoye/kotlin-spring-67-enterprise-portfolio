package com.portfolio.smartinventory.domain.repository
import com.portfolio.smartinventory.domain.model.*
interface SmartInventoryRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}