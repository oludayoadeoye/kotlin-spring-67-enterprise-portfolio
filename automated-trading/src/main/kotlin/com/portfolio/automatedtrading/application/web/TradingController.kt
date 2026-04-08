package com.portfolio.automatedtrading.application.web

import com.portfolio.automatedtrading.domain.service.TradingService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trading")
@Tag(name = "Trading", description = "Algorithmic trading endpoints")
class TradingController(private val service: TradingService) {
    @GetMapping("/signal/{symbol}") suspend fun signal(@PathVariable symbol: String) = service.generateSignal(symbol)
    @GetMapping("/history") suspend fun history() = service.getHistory()
}
