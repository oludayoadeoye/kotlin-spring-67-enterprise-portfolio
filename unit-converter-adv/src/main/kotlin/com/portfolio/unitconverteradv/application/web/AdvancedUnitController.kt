package com.portfolio.unitconverteradv.application.web

import com.portfolio.unitconverteradv.domain.service.AdvancedUnitService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/convert/adv")
class AdvancedUnitController(private val service: AdvancedUnitService) {
    @GetMapping("/temp") fun temp(@RequestParam v: Double, @RequestParam to: String) = service.convertTemp(v, to)
}
