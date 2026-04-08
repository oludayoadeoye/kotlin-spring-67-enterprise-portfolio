package com.portfolio.currencyconverter.infrastructure.persistence

import com.portfolio.currencyconverter.domain.model.ExchangeRate
import jakarta.persistence.*

@Entity
@Table(name = "exchange_rates")
class ExchangeRateEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true, nullable = false)
    val currencyPair: String,
    @Column(nullable = false)
    val rate: Double
) {
    fun toDomain() = ExchangeRate(id, currencyPair, rate)
    companion object {
        fun fromDomain(e: ExchangeRate) = ExchangeRateEntity(e.id, e.currencyPair, e.rate)
    }
}
