package com.portfolio.automatedtradingsystem.domain.repository
import com.portfolio.automatedtradingsystem.domain.model.*
interface AutomatedTradingSystemRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}