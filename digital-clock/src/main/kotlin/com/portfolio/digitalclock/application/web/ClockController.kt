package com.portfolio.digitalclock.application.web

import com.portfolio.digitalclock.domain.service.ClockService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clock")
@Tag(name = "Clock", description = "Digital clock endpoints")
class ClockController(private val service: ClockService) {
    @GetMapping("/now") suspend fun now() = service.getCurrentTime()
    @GetMapping("/history") suspend fun history() = service.getHistory()
}
