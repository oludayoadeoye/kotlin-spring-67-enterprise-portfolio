package com.portfolio.expensetrackeradv.domain.repository
import com.portfolio.expensetrackeradv.domain.model.*
interface ExpenseTrackerAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}