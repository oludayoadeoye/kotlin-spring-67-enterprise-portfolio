package com.portfolio.currencyconverter.infrastructure.persistence

import com.portfolio.currencyconverter.domain.model.ExchangeRate
import com.portfolio.currencyconverter.domain.repository.ExchangeRateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataExchangeRateRepository : JpaRepository<ExchangeRateEntity, Long> {
    fun findByCurrencyPair(pair: String): ExchangeRateEntity?
}

@Repository
class JpaExchangeRateRepositoryAdapter(private val repository: SpringDataExchangeRateRepository) : ExchangeRateRepository {
    override suspend fun findByPair(pair: String): ExchangeRate? = withContext(Dispatchers.IO) {
        repository.findByCurrencyPair(pair)?.toDomain()
    }

    override suspend fun save(rate: ExchangeRate): ExchangeRate = withContext(Dispatchers.IO) {
        repository.save(ExchangeRateEntity.fromDomain(rate)).toDomain()
    }

    override suspend fun findAll(): List<ExchangeRate> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
