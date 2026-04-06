package com.portfolio.realtimestock.domain.model

data class StockQuote(
    val symbol: String,
    val price: Double,
    val change: Double
)
