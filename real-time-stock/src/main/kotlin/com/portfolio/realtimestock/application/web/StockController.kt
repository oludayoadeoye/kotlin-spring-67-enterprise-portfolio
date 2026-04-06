package com.portfolio.realtimestock.application.web

import com.portfolio.realtimestock.domain.service.StockService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/stocks")
class StockController(private val service: StockService) {
    @GetMapping("/{symbol}") fun quote(@PathVariable symbol: String) = service.getQuote(symbol)
}
