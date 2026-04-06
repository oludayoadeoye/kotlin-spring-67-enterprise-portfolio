package com.portfolio.automatedtrading.application.web

import com.portfolio.automatedtrading.domain.service.TradingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trading")
class TradingController(private val service: TradingService) {
    @GetMapping("/signal/{symbol}") fun signal(@PathVariable symbol: String) = service.generateSignal(symbol)
}
