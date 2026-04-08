package com.portfolio.expensetrackeradv.domain.service

import com.portfolio.expensetrackeradv.domain.model.DetailedExpense
import com.portfolio.expensetrackeradv.domain.model.BudgetReport
import com.portfolio.expensetrackeradv.domain.model.ProcessedRequest
import com.portfolio.expensetrackeradv.domain.repository.ExpenseAdvRepository
import com.portfolio.expensetrackeradv.domain.repository.IdempotencyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BudgetService(
    private val expenseRepository: ExpenseAdvRepository,
    private val idempotencyRepository: IdempotencyRepository
) {
    suspend fun getReport(): List<BudgetReport> {
        val expenses = expenseRepository.findAll()
        val totals = expenses.groupBy { it.category }.mapValues { it.value.sumOf { e -> e.amount } }
        
        // Mocking limits for the report logic
        val limits = mapOf("Food" to 500.0, "Rent" to 1200.0)
        
        return limits.map { (cat, limit) ->
            val spent = totals[cat] ?: 0.0
            BudgetReport(cat, spent, limit, limit - spent)
        }
    }

    @Transactional
    suspend fun addExpense(expense: DetailedExpense, idempotencyKey: String?): Pair<DetailedExpense?, Int> {
        if (idempotencyKey != null) {
            val existing = idempotencyRepository.findByKey(idempotencyKey)
            if (existing != null) return null to 409
        }

        val saved = expenseRepository.save(expense)
        
        if (idempotencyKey != null) {
            idempotencyRepository.save(ProcessedRequest(idempotencyKey, null, 201))
        }
        
        return saved to 201
    }
}
