package com.portfolio.unitconverter.application.web

import com.portfolio.unitconverter.domain.model.ConversionRecord
import com.portfolio.unitconverter.domain.service.UnitService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/convert")
class UnitController(private val unitService: UnitService) {

    @PostMapping
    @Operation(summary = "Convert units and store in history")
    suspend fun convert(@RequestParam value: Double, @RequestParam from: String, @RequestParam to: String): ConversionRecord =
        unitService.convert(value, from, to)

    @GetMapping("/history")
    suspend fun history(): List<ConversionRecord> = unitService.getHistory()
}
