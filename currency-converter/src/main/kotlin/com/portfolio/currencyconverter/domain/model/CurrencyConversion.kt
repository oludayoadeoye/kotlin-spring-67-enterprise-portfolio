package com.portfolio.currencyconverter.domain.model

data class CurrencyConversion(
    val from: String,
    val to: String,
    val amount: Double,
    val convertedAmount: Double,
    val rate: Double
)
