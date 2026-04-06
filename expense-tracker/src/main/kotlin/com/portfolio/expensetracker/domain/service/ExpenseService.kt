package com.portfolio.expensetracker.domain.service

import com.portfolio.expensetracker.domain.model.Expense
import org.springframework.stereotype.Service

@Service
class ExpenseService {
    private val expenses = mutableListOf<Expense>()

    fun getAll(): List<Expense> = expenses
    fun add(expense: Expense): Expense {
        val newExpense = expense.copy(id = (expenses.size + 1).toLong())
        expenses.add(newExpense)
        return newExpense
    }
}
