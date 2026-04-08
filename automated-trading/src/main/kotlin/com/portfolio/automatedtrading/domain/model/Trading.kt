package com.portfolio.automatedtrading.domain.model

import java.time.LocalDateTime

data class TradeSignal(
    val id: Long? = null,
    val symbol: String,
    val action: String,
    val confidence: Double,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
