package com.portfolio.currencyconverter.domain.model

data class ExchangeRate(
    val id: Long? = null,
    val currencyPair: String,
    val rate: Double
)

data class ConversionResult(
    val from: String,
    val to: String,
    val amount: Double,
    val convertedAmount: Double,
    val rate: Double
)
