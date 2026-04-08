package com.portfolio.advancedanalyticsplatform.domain.repository
import com.portfolio.advancedanalyticsplatform.domain.model.*
interface AdvancedAnalyticsPlatformRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}