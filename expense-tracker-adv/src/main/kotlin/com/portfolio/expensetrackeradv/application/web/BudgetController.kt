package com.portfolio.expensetrackeradv.application.web

import com.portfolio.expensetrackeradv.domain.model.DetailedExpense
import com.portfolio.expensetrackeradv.domain.service.BudgetService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/expenses/adv")
@Tag(name = "Expense Adv", description = "Advanced financial tracking with idempotency")
class BudgetController(private val service: BudgetService) {

    @GetMapping("/report")
    suspend fun report() = service.getReport()

    @PostMapping
    suspend fun add(
        @RequestBody expense: DetailedExpense,
        @RequestHeader(value = "X-Idempotency-Key", required = false) key: String?
    ): ResponseEntity<Any> {
        val (saved, status) = service.addExpense(expense, key)
        return if (saved != null) {
            ResponseEntity.status(HttpStatus.CREATED).body(saved)
        } else {
            ResponseEntity.status(status).body(mapOf("error" to "Conflict or Duplicate"))
        }
    }
}
