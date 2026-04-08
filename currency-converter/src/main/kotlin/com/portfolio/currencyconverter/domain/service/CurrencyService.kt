package com.portfolio.currencyconverter.domain.service

import com.portfolio.currencyconverter.domain.model.ConversionResult
import com.portfolio.currencyconverter.domain.model.ExchangeRate
import com.portfolio.currencyconverter.domain.repository.ExchangeRateRepository
import org.springframework.stereotype.Service

@Service
class CurrencyService(private val repository: ExchangeRateRepository) {
    
    suspend fun convert(from: String, to: String, amount: Double): ConversionResult {
        val pair = "${from.uppercase()}_${to.uppercase()}"
        val rate = repository.findByPair(pair)?.rate ?: 1.0
        return ConversionResult(from, to, amount, amount * rate, rate)
    }

    suspend fun updateRate(from: String, to: String, rate: Double): ExchangeRate {
        val pair = "${from.uppercase()}_${to.uppercase()}"
        val existing = repository.findByPair(pair)
        val toSave = ExchangeRate(id = existing?.id, currencyPair = pair, rate = rate)
        return repository.save(toSave)
    }

    suspend fun getAllRates(): List<ExchangeRate> = repository.findAll()
}
