package com.portfolio.customoperatingsystem.domain.repository
import com.portfolio.customoperatingsystem.domain.model.*
interface CustomOperatingSystemRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}