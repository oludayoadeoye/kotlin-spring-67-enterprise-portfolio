package com.portfolio.automatedtrading.domain.repository
import com.portfolio.automatedtrading.domain.model.*
interface AutomatedTradingRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}