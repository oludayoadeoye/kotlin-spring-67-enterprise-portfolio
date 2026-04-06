package com.portfolio.advancedanalytics.application.web

import com.portfolio.advancedanalytics.domain.service.AnalyticsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/analytics")
class AnalyticsController(private val service: AnalyticsService) {
    @GetMapping("/report") fun report() = service.generateReport()
}
