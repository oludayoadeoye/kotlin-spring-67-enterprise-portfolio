package com.portfolio.digitalclock.application.web

import com.portfolio.digitalclock.domain.model.TimeResponse
import com.portfolio.digitalclock.domain.service.ClockService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clock")
class ClockController(private val clockService: ClockService) {
    @GetMapping("/now") fun now(): TimeResponse = clockService.getCurrentTime()
}
