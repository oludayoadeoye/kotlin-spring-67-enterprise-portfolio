package com.portfolio.advancedanalyticsplatform.application.web

import com.portfolio.advancedanalyticsplatform.domain.service.AdvancedPlatformService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/analytics/platform")
class PlatformController(private val service: AdvancedPlatformService) {
    @GetMapping("/health") fun health() = service.getClusterHealth()
}
