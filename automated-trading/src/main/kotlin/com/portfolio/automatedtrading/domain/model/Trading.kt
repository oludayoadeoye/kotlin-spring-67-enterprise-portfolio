package com.portfolio.automatedtrading.domain.model

data class TradeSignal(
    val symbol: String,
    val action: String, // "Buy", "Sell", "Hold"
    val confidence: Double
)
