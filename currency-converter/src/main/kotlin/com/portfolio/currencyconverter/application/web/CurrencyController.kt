package com.portfolio.currencyconverter.application.web

import com.portfolio.currencyconverter.domain.model.CurrencyConversion
import com.portfolio.currencyconverter.domain.service.CurrencyService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/currency")
@Tag(name = "Currency", description = "Currency conversion endpoints")
class CurrencyController(private val currencyService: CurrencyService) {

    @GetMapping("/convert")
    @Operation(summary = "Convert amount between currencies")
    fun convert(
        @RequestParam from: String,
        @RequestParam to: String,
        @RequestParam amount: Double
    ): CurrencyConversion = currencyService.convert(from, to, amount)
}
