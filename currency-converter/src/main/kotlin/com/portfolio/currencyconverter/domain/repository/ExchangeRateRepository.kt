package com.portfolio.currencyconverter.domain.repository

import com.portfolio.currencyconverter.domain.model.ExchangeRate

interface ExchangeRateRepository {
    suspend fun findByPair(pair: String): ExchangeRate?
    suspend fun save(rate: ExchangeRate): ExchangeRate
    suspend fun findAll(): List<ExchangeRate>
}
