package com.portfolio.automatedtradingsystem.domain.service

import com.portfolio.automatedtradingsystem.domain.model.OrderBook
import org.springframework.stereotype.Service

@Service
class AdvancedExchangeService {
    fun getOrderBook(): OrderBook = OrderBook(
        mapOf(150.0 to 10.0, 149.5 to 50.0),
        mapOf(150.5 to 20.0, 151.0 to 100.0)
    )
}
