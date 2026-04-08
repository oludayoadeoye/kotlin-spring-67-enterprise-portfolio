package com.portfolio.cybersecuritymonitoring.application.web

import com.portfolio.cybersecuritymonitoring.domain.service.MonitoringService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/security")
@Tag(name = "Security", description = "Cybersecurity monitoring endpoints")
class SecurityController(private val service: MonitoringService) {
    @GetMapping("/alerts") suspend fun alerts() = service.getActiveAlerts()
    @PostMapping("/alerts") suspend fun log(@RequestParam sev: String, @RequestParam ip: String) = service.logAlert(sev, ip)
}
