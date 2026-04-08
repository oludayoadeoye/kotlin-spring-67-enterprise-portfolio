package com.portfolio.expensetracker.domain.repository

import com.portfolio.expensetracker.domain.model.Expense
import com.portfolio.expensetracker.domain.model.ProcessedRequest

interface ExpenseRepository {
    suspend fun findAll(): List<Expense>
    suspend fun save(expense: Expense): Expense
}

interface IdempotencyRepository {
    suspend fun findByKey(key: String): ProcessedRequest?
    suspend fun save(request: ProcessedRequest)
}
