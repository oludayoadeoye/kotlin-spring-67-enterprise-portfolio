package com.portfolio.expensetracker.application.web

import com.portfolio.expensetracker.domain.model.Expense
import com.portfolio.expensetracker.domain.service.ExpenseService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/expenses")
class ExpenseController(private val expenseService: ExpenseService) {

    @GetMapping
    suspend fun list() = expenseService.getAll()

    @PostMapping
    @Operation(summary = "Add expense with idempotency check")
    suspend fun create(
        @RequestBody expense: Expense,
        @RequestHeader(value = "X-Idempotency-Key", required = false) 
        @Parameter(description = "Unique key to prevent duplicate processing")
        idempotencyKey: String?
    ): ResponseEntity<Any> {
        val (saved, status) = expenseService.addExpense(expense, idempotencyKey)
        return if (saved != null) {
            ResponseEntity.status(HttpStatus.CREATED).body(saved)
        } else {
            ResponseEntity.status(status).body(mapOf("error" to "Duplicate request processed"))
        }
    }
}
