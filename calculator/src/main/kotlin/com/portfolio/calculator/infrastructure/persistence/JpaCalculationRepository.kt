package com.portfolio.calculator.infrastructure.persistence

import com.portfolio.calculator.domain.model.Calculation
import com.portfolio.calculator.domain.repository.CalculationRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataCalculationRepository : JpaRepository<CalculationEntity, Long>

@Repository
class JpaCalculationRepositoryAdapter(private val repository: SpringDataCalculationRepository) : CalculationRepository {
    override fun save(calculation: Calculation): Calculation = 
        repository.save(CalculationEntity.fromDomain(calculation)).toDomain()

    override fun findAll(): List<Calculation> = 
        repository.findAll().map { it.toDomain() }
}
