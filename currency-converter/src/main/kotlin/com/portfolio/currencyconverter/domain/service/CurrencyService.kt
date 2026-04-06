package com.portfolio.currencyconverter.domain.service

import com.portfolio.currencyconverter.domain.model.CurrencyConversion
import org.springframework.stereotype.Service

@Service
class CurrencyService {
    private val mockRates = mapOf("USD_EUR" to 0.92, "EUR_USD" to 1.09, "USD_GBP" to 0.79)

    fun convert(from: String, to: String, amount: Double): CurrencyConversion {
        val key = "${from.uppercase()}_${to.uppercase()}"
        val rate = mockRates[key] ?: 1.0
        return CurrencyConversion(from, to, amount, amount * rate, rate)
    }
}
