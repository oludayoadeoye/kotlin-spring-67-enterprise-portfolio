package com.portfolio.realtimestock.domain.service

import com.portfolio.realtimestock.domain.model.StockQuote
import org.springframework.stereotype.Service

@Service
class StockService {
    fun getQuote(symbol: String): StockQuote {
        return StockQuote(symbol.uppercase(), 150.0 + Math.random() * 10, Math.random() - 0.5)
    }
}
