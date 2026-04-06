package com.portfolio.expensetracker.application.web

import com.portfolio.expensetracker.domain.model.Expense
import com.portfolio.expensetracker.domain.service.ExpenseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/expenses")
class ExpenseController(private val expenseService: ExpenseService) {
    @GetMapping fun list() = expenseService.getAll()
    @PostMapping fun create(@RequestBody expense: Expense) = expenseService.add(expense)
}
