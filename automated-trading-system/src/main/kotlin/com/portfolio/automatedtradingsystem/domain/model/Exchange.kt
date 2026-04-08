package com.portfolio.automatedtradingsystem.domain.model

data class OrderBookEntry(
    val id: Long? = null,
    val symbol: String,
    val side: String,
    val price: Double,
    val quantity: Double
)

data class OrderBook(
    val symbol: String,
    val bids: List<OrderBookEntry>,
    val asks: List<OrderBookEntry>
)
