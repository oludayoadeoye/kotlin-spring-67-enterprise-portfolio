package com.portfolio.smarthomesecurity.application.web

import com.portfolio.smarthomesecurity.domain.model.SecurityEvent
import com.portfolio.smarthomesecurity.domain.service.SecurityService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/security/home")
@Tag(name = "Security", description = "Home security monitoring endpoints")
class SecurityController(private val service: SecurityService) {
    @GetMapping("/status") suspend fun status() = service.getStatus()
    @PostMapping("/events") @ResponseStatus(HttpStatus.CREATED) suspend fun log(@RequestBody event: SecurityEvent) = service.logEvent(event)
    @GetMapping("/events") suspend fun history() = service.getEventHistory()
}
