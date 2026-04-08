package com.portfolio.expensetracker.infrastructure.persistence

import com.portfolio.expensetracker.domain.model.Expense
import com.portfolio.expensetracker.domain.model.ProcessedRequest
import com.portfolio.expensetracker.domain.repository.ExpenseRepository
import com.portfolio.expensetracker.domain.repository.IdempotencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataExpenseRepository : JpaRepository<ExpenseEntity, Long>
interface SpringDataRequestLogRepository : JpaRepository<RequestLogEntity, String>

@Repository
class JpaExpenseRepositoryAdapter(private val repository: SpringDataExpenseRepository) : ExpenseRepository {
    override suspend fun findAll(): List<Expense> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(expense: Expense): Expense = withContext(Dispatchers.IO) {
        repository.save(ExpenseEntity.fromDomain(expense)).toDomain()
    }
}

@Repository
class JpaIdempotencyRepositoryAdapter(private val repository: SpringDataRequestLogRepository) : IdempotencyRepository {
    override suspend fun findByKey(key: String): ProcessedRequest? = withContext(Dispatchers.IO) {
        repository.findById(key).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(request: ProcessedRequest) = withContext(Dispatchers.IO) {
        repository.save(RequestLogEntity.fromDomain(request))
        Unit
    }
}
