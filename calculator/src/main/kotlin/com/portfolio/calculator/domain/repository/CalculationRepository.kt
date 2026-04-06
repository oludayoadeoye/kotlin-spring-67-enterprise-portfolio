package com.portfolio.calculator.domain.repository

import com.portfolio.calculator.domain.model.Calculation

interface CalculationRepository {
    fun save(calculation: Calculation): Calculation
    fun findAll(): List<Calculation>
}
