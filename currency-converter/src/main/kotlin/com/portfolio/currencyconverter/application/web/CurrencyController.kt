package com.portfolio.currencyconverter.application.web

import com.portfolio.currencyconverter.domain.model.ConversionResult
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
    suspend fun convert(
        @RequestParam from: String,
        @RequestParam to: String,
        @RequestParam amount: Double
    ): ConversionResult = currencyService.convert(from, to, amount)

    @GetMapping("/rates")
    suspend fun rates() = currencyService.getAllRates()

    @PostMapping("/rates")
    suspend fun updateRate(@RequestParam from: String, @RequestParam to: String, @RequestParam rate: Double) =
        currencyService.updateRate(from, to, rate)
}
