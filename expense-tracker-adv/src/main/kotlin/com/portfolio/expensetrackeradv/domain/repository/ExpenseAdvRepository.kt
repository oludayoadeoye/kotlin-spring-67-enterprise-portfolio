package com.portfolio.expensetrackeradv.domain.repository

import com.portfolio.expensetrackeradv.domain.model.DetailedExpense
import com.portfolio.expensetrackeradv.domain.model.ProcessedRequest

interface ExpenseAdvRepository {
    suspend fun findAll(): List<DetailedExpense>
    suspend fun findByCategory(category: String): List<DetailedExpense>
    suspend fun save(expense: DetailedExpense): DetailedExpense
}

interface IdempotencyRepository {
    suspend fun findByKey(key: String): ProcessedRequest?
    suspend fun save(request: ProcessedRequest)
}
