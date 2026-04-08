package com.portfolio.calculator.application.web

import com.portfolio.calculator.domain.model.Calculation
import com.portfolio.calculator.domain.service.CalculatorService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/calculator")
@Tag(name = "Calculator", description = "Endpoints for math operations")
class CalculatorController(private val calculatorService: CalculatorService) {

    @PostMapping("/evaluate")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Evaluate a basic math expression (e.g. 10+5)")
    suspend fun evaluate(@RequestParam expression: String): Calculation = calculatorService.calculate(expression)

    @GetMapping("/history")
    @Operation(summary = "Get calculation history")
    suspend fun getHistory(): List<Calculation> = calculatorService.getHistory()

    @GetMapping("/{id}")
    suspend fun getById(@PathVariable id: Long): ResponseEntity<Calculation> =
        calculatorService.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun delete(@PathVariable id: Long) = calculatorService.delete(id)
}
