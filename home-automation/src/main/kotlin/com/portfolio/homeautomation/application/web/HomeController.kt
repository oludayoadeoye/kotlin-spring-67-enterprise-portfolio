package com.portfolio.homeautomation.application.web

import com.portfolio.homeautomation.domain.service.AutomationService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/home")
@Tag(name = "Automation", description = "Home automation endpoints")
class HomeController(private val service: AutomationService) {
    @GetMapping("/devices") suspend fun list() = service.getDevices()
    @PostMapping("/toggle/{id}") suspend fun toggle(@PathVariable id: Long) = service.toggleDevice(id)
}
