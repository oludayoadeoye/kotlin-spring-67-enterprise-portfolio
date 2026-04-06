package com.portfolio.cybersecuritymonitoring.application.web

import com.portfolio.cybersecuritymonitoring.domain.service.MonitoringService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/security")
class SecurityController(private val service: MonitoringService) {
    @GetMapping("/alerts") fun alerts() = service.getActiveAlerts()
}
