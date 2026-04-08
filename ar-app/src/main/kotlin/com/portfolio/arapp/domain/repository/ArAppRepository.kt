package com.portfolio.arapp.domain.repository
import com.portfolio.arapp.domain.model.*
interface ArAppRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}