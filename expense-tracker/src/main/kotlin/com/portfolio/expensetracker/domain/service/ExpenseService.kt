package com.portfolio.expensetracker.domain.service

import com.portfolio.expensetracker.domain.model.Expense
import com.portfolio.expensetracker.domain.model.ProcessedRequest
import com.portfolio.expensetracker.domain.repository.ExpenseRepository
import com.portfolio.expensetracker.domain.repository.IdempotencyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ExpenseService(
    private val expenseRepository: ExpenseRepository,
    private val idempotencyRepository: IdempotencyRepository
) {
    suspend fun getAll(): List<Expense> = expenseRepository.findAll()

    @Transactional
    suspend fun addExpense(expense: Expense, idempotencyKey: String?): Pair<Expense?, Int> {
        if (idempotencyKey != null) {
            val existing = idempotencyRepository.findByKey(idempotencyKey)
            if (existing != null) {
                // Return cached result (Simulated for this portfolio)
                return null to 409 // Conflict or return cached response
            }
        }

        val saved = expenseRepository.save(expense)
        
        if (idempotencyKey != null) {
            idempotencyRepository.save(ProcessedRequest(idempotencyKey, null, 201))
        }
        
        return saved to 201
    }
}
