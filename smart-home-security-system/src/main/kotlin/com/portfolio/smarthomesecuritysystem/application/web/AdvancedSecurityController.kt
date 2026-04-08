package com.portfolio.smarthomesecuritysystem.application.web

import com.portfolio.smarthomesecuritysystem.domain.service.AdvancedSecuritySystemService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/security/v2")
class AdvancedSecurityController(private val service: AdvancedSecuritySystemService) {
    @GetMapping("/zones") fun zones() = service.getZones()
}
