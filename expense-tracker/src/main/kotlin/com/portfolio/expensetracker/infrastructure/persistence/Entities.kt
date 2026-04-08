package com.portfolio.expensetracker.infrastructure.persistence

import com.portfolio.expensetracker.domain.model.ProcessedRequest
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "request_logs")
class RequestLogEntity(
    @Id
    val id: String,
    val responseBody: String?,
    val statusCode: Int,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = ProcessedRequest(id, responseBody, statusCode, createdAt)
    companion object {
        fun fromDomain(r: ProcessedRequest) = RequestLogEntity(r.key, r.responseBody, r.statusCode, r.createdAt)
    }
}

@Entity
@Table(name = "expenses")
class ExpenseEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val amount: Double,
    val description: String,
    val category: String,
    val date: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = com.portfolio.expensetracker.domain.model.Expense(id, amount, description, category, date)
    companion object {
        fun fromDomain(e: com.portfolio.expensetracker.domain.model.Expense) = ExpenseEntity(e.id, e.amount, e.description, e.category, e.date)
    }
}
