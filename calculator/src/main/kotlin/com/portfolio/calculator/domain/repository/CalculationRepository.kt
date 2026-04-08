package com.portfolio.calculator.domain.repository

import com.portfolio.calculator.domain.model.Calculation

interface CalculationRepository {
    suspend fun save(calculation: Calculation): Calculation
    suspend fun findAll(): List<Calculation>
    suspend fun findById(id: Long): Calculation?
    suspend fun deleteById(id: Long)
}
