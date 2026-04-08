package com.portfolio.healthcaremgmt.domain.repository
import com.portfolio.healthcaremgmt.domain.model.*
interface HealthcareMgmtRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}