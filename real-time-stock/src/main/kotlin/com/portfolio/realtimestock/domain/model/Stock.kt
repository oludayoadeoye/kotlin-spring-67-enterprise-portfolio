package com.portfolio.realtimestock.domain.model

import java.time.LocalDateTime

data class StockQuote(
    val symbol: String,
    val price: Double,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

data class AnalysisResult(
    val symbol: String,
    val indicator: String,
    val value: Double,
    val recommendation: String
)
