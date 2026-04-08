package com.portfolio.librarymanagementadv.domain.repository
import com.portfolio.librarymanagementadv.domain.model.*
interface LibraryManagementAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}