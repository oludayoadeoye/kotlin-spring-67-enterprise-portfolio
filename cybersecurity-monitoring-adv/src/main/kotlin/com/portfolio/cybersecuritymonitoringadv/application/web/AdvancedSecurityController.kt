package com.portfolio.cybersecuritymonitoringadv.application.web

import com.portfolio.cybersecuritymonitoringadv.domain.service.AdvancedSecurityService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/security/adv")
class AdvancedSecurityController(private val service: AdvancedSecurityService) {
    @PostMapping("/audit") fun audit(@RequestParam id: String) = service.runAudit(id)
}
