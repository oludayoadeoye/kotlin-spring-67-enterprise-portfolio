package com.portfolio.automatedtradingsystem.application.web

import com.portfolio.automatedtradingsystem.domain.service.AdvancedExchangeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trading/v2")
class AdvancedTradingController(private val service: AdvancedExchangeService) {
    @GetMapping("/book") fun book() = service.getOrderBook()
}
