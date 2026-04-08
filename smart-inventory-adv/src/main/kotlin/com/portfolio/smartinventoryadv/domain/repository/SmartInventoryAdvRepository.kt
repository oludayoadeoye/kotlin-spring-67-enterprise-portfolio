package com.portfolio.smartinventoryadv.domain.repository
import com.portfolio.smartinventoryadv.domain.model.*
interface SmartInventoryAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}