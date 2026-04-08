package com.portfolio.realtimestock.application.web

import com.portfolio.realtimestock.domain.service.StockService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/stocks")
@Tag(name = "Stocks", description = "Stock market analysis endpoints")
class StockController(private val service: StockService) {
    @GetMapping("/{symbol}/analyze") suspend fun analyze(@PathVariable symbol: String) = service.analyze(symbol)
    @PostMapping("/{symbol}/log") suspend fun log(@PathVariable symbol: String, @RequestParam price: Double) = service.logQuote(symbol, price)
}
