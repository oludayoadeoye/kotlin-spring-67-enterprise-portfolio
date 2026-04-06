package com.portfolio.unitconverter.application.web

import com.portfolio.unitconverter.domain.service.UnitService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/convert")
class UnitController(private val unitService: UnitService) {
    @GetMapping
    fun convert(@RequestParam value: Double, @RequestParam from: String, @RequestParam to: String) =
        unitService.convert(value, from, to)
}
