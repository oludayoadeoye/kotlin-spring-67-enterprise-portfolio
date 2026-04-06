package com.portfolio.digitalclockadv.application.web

import com.portfolio.digitalclockadv.domain.service.AdvancedClockService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clock/adv")
class AdvancedClockController(private val service: AdvancedClockService) {
    @GetMapping("/world") fun world(@RequestParam city: String, @RequestParam zone: String) = service.getWorldTime(city, zone)
}
