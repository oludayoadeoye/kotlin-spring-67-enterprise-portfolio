package com.portfolio.expensetrackeradv.domain.model

data class BudgetReport(
    val category: String,
    val spent: Double,
    val limit: Double,
    val remaining: Double
)
