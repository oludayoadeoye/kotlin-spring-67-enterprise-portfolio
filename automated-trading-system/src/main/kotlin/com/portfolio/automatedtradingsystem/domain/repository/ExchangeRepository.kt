package com.portfolio.automatedtradingsystem.domain.repository

import com.portfolio.automatedtradingsystem.domain.model.OrderBookEntry

interface ExchangeRepository {
    suspend fun findAllBySymbol(symbol: String): List<OrderBookEntry>
    suspend fun save(entry: OrderBookEntry): OrderBookEntry
}
