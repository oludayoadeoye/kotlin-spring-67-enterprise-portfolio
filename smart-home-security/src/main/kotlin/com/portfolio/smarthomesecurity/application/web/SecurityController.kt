package com.portfolio.smarthomesecurity.application.web

import com.portfolio.smarthomesecurity.domain.service.SecurityService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/security/home")
class SecurityController(private val service: SecurityService) {
    @GetMapping("/status") fun status() = service.getStatus()
}
