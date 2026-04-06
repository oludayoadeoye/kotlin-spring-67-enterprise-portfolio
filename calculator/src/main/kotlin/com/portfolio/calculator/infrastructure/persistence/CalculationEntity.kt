package com.portfolio.calculator.infrastructure.persistence

import com.portfolio.calculator.domain.model.Calculation
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "calculation_history")
class CalculationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val expression: String,
    val result: Double,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Calculation(id, expression, result, timestamp)

    companion object {
        fun fromDomain(c: Calculation) = CalculationEntity(c.id, c.expression, c.result, c.timestamp)
    }
}
