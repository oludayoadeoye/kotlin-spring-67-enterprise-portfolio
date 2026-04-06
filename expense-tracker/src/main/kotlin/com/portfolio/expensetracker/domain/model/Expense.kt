package com.portfolio.expensetracker.domain.model

import java.time.LocalDateTime

data class Expense(
    val id: Long? = null,
    val amount: Double,
    val description: String,
    val category: String,
    val date: LocalDateTime = LocalDateTime.now()
)
