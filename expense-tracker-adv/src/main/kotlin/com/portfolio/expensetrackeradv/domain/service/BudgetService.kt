package com.portfolio.expensetrackeradv.domain.service

import com.portfolio.expensetrackeradv.domain.model.BudgetReport
import org.springframework.stereotype.Service

@Service
class BudgetService {
    fun getReport(): List<BudgetReport> = listOf(
        BudgetReport("Food", 450.0, 500.0, 50.0),
        BudgetReport("Rent", 1200.0, 1200.0, 0.0)
    )
}
