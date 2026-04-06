package com.portfolio.calculator.application.web

import com.portfolio.calculator.domain.model.Calculation
import com.portfolio.calculator.domain.service.CalculatorService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/calculator")
@Tag(name = "Calculator", description = "Endpoints for math operations")
class CalculatorController(private val calculatorService: CalculatorService) {

    @PostMapping("/evaluate")
    @Operation(summary = "Evaluate a basic math expression (e.g. 10+5)")
    fun evaluate(@RequestParam expression: String): Calculation = calculatorService.calculate(expression)

    @GetMapping("/history")
    @Operation(summary = "Get calculation history")
    fun getHistory(): List<Calculation> = calculatorService.getHistory()
}
