package com.portfolio.automatedtrading.domain.service

import com.portfolio.automatedtrading.domain.model.TradeSignal
import com.portfolio.automatedtrading.domain.repository.TradingRepository
import org.springframework.stereotype.Service

@Service
class TradingService(private val repository: TradingRepository) {
    suspend fun generateSignal(symbol: String): TradeSignal {
        // Mock HFT algorithm
        val signal = TradeSignal(symbol = symbol.uppercase(), action = "Buy", confidence = 0.89)
        return repository.save(signal)
    }

    suspend fun getHistory(): List<TradeSignal> = repository.findAll()
}
