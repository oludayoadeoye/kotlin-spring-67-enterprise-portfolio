package com.portfolio.expensetrackeradv.domain.model

import java.time.LocalDateTime

data class DetailedExpense(
    val id: Long? = null,
    val amount: Double,
    val category: String,
    val description: String?,
    val date: LocalDateTime = LocalDateTime.now()
)

data class BudgetReport(
    val category: String,
    val spent: Double,
    val limit: Double,
    val remaining: Double
)

data class ProcessedRequest(
    val key: String,
    val responseBody: String?,
    val statusCode: Int,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
