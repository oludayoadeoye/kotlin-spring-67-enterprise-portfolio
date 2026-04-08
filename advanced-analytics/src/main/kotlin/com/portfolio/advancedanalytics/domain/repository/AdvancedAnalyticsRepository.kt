package com.portfolio.advancedanalytics.domain.repository
import com.portfolio.advancedanalytics.domain.model.*
interface AdvancedAnalyticsRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}