package com.portfolio.automatedtradingsystem.domain.model

data class OrderBook(
    val bids: Map<Double, Double>,
    val asks: Map<Double, Double>
)
