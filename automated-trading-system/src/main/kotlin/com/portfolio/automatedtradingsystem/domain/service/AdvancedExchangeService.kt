package com.portfolio.automatedtradingsystem.domain.service

import com.portfolio.automatedtradingsystem.domain.model.OrderBook
import com.portfolio.automatedtradingsystem.domain.model.OrderBookEntry
import com.portfolio.automatedtradingsystem.domain.repository.ExchangeRepository
import org.springframework.stereotype.Service

@Service
class AdvancedExchangeService(private val repository: ExchangeRepository) {
    suspend fun getOrderBook(symbol: String): OrderBook {
        val entries = repository.findAllBySymbol(symbol)
        return OrderBook(
            symbol = symbol,
            bids = entries.filter { it.side == "BID" }.sortedByDescending { it.price },
            asks = entries.filter { it.side == "ASK" }.sortedBy { it.price }
        )
    }

    suspend fun addEntry(entry: OrderBookEntry) = repository.save(entry)
}
