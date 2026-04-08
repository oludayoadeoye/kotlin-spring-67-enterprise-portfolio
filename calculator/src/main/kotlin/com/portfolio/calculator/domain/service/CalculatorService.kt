package com.portfolio.calculator.domain.service

import com.portfolio.calculator.domain.model.Calculation
import com.portfolio.calculator.domain.repository.CalculationRepository
import org.springframework.stereotype.Service

@Service
class CalculatorService(private val repository: CalculationRepository) {
    
    suspend fun calculate(expression: String): Calculation {
        val result = evaluateBasic(expression)
        val calculation = Calculation(expression = expression, result = result)
        return repository.save(calculation)
    }

    private fun evaluateBasic(expression: String): Double {
        return try {
            val parts = expression.split("+", "-", "*", "/")
            if (parts.size < 2) return expression.toDouble()
            
            val first = parts[0].trim().toDouble()
            val second = parts[1].trim().toDouble()
            
            when {
                expression.contains("+") -> first + second
                expression.contains("-") -> first - second
                expression.contains("*") -> first * second
                expression.contains("/") -> first / second
                else -> 0.0
            }
        } catch (e: Exception) {
            0.0
        }
    }

    suspend fun getHistory(): List<Calculation> = repository.findAll()
    suspend fun getById(id: Long): Calculation? = repository.findById(id)
    suspend fun delete(id: Long) = repository.deleteById(id)
}
