package com.portfolio.automatedtradingsystem.application.web

import com.portfolio.automatedtradingsystem.domain.model.OrderBookEntry
import com.portfolio.automatedtradingsystem.domain.service.AdvancedExchangeService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trading/v2")
@Tag(name = "Trading Adv", description = "Advanced exchange and order book endpoints")
class AdvancedTradingController(private val service: AdvancedExchangeService) {
    @GetMapping("/book/{symbol}") suspend fun book(@PathVariable symbol: String) = service.getOrderBook(symbol)
    @PostMapping("/book") @ResponseStatus(HttpStatus.CREATED) suspend fun add(@RequestBody entry: OrderBookEntry) = service.addEntry(entry)
}
