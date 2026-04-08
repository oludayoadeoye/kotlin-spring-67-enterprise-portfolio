package com.portfolio.expensetrackeradv.infrastructure.persistence

import com.portfolio.expensetrackeradv.domain.model.DetailedExpense
import com.portfolio.expensetrackeradv.domain.model.ProcessedRequest
import com.portfolio.expensetrackeradv.domain.repository.ExpenseAdvRepository
import com.portfolio.expensetrackeradv.domain.repository.IdempotencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity @Table(name = "detailed_expenses")
class DetailedExpenseEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val amount: Double,
    val category: String,
    val description: String?,
    val date: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = DetailedExpense(id, amount, category, description, date)
    companion object {
        fun fromDomain(e: DetailedExpense) = DetailedExpenseEntity(e.id, e.amount, e.category, e.description, e.date)
    }
}

@Entity @Table(name = "request_logs")
class RequestLogEntity(
    @Id val id: String,
    val responseBody: String?,
    val statusCode: Int,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = ProcessedRequest(id, responseBody, statusCode, createdAt)
    companion object {
        fun fromDomain(r: ProcessedRequest) = RequestLogEntity(r.key, r.responseBody, r.statusCode, r.createdAt)
    }
}

interface SpringDataExpenseAdvRepository : JpaRepository<DetailedExpenseEntity, Long> {
    fun findByCategory(category: String): List<DetailedExpenseEntity>
}
interface SpringDataRequestLogRepository : JpaRepository<RequestLogEntity, String>

@Repository
class JpaExpenseAdvRepositoryAdapter(
    private val expenseRepo: SpringDataExpenseAdvRepository,
    private val logRepo: SpringDataRequestLogRepository
) : ExpenseAdvRepository, IdempotencyRepository {
    override suspend fun findAll(): List<DetailedExpense> = withContext(Dispatchers.IO) {
        expenseRepo.findAll().map { it.toDomain() }
    }
    override suspend fun findByCategory(category: String): List<DetailedExpense> = withContext(Dispatchers.IO) {
        expenseRepo.findByCategory(category).map { it.toDomain() }
    }
    override suspend fun save(expense: DetailedExpense): DetailedExpense = withContext(Dispatchers.IO) {
        expenseRepo.save(DetailedExpenseEntity.fromDomain(expense)).toDomain()
    }
    override suspend fun findByKey(key: String): ProcessedRequest? = withContext(Dispatchers.IO) {
        logRepo.findById(key).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(request: ProcessedRequest) = withContext(Dispatchers.IO) {
        logRepo.save(RequestLogEntity.fromDomain(request))
        Unit
    }
}
