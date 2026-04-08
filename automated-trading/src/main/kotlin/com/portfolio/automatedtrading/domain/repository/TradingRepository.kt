package com.portfolio.automatedtrading.domain.repository

import com.portfolio.automatedtrading.domain.model.TradeSignal

interface TradingRepository {
    suspend fun save(signal: TradeSignal): TradeSignal
    suspend fun findAll(): List<TradeSignal>
}
