package com.portfolio.calculator.infrastructure.persistence

import com.portfolio.calculator.domain.model.Calculation
import com.portfolio.calculator.domain.repository.CalculationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataCalculationRepository : JpaRepository<CalculationEntity, Long>

@Repository
class JpaCalculationRepositoryAdapter(private val repository: SpringDataCalculationRepository) : CalculationRepository {
    override suspend fun save(calculation: Calculation): Calculation = withContext(Dispatchers.IO) {
        repository.save(CalculationEntity.fromDomain(calculation)).toDomain()
    }

    override suspend fun findAll(): List<Calculation> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }

    override suspend fun findById(id: Long): Calculation? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
