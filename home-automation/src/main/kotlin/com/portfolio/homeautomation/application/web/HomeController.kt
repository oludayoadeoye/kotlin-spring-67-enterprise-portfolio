package com.portfolio.homeautomation.application.web

import com.portfolio.homeautomation.domain.service.AutomationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/home")
class HomeController(private val service: AutomationService) {
    @GetMapping("/devices") fun list() = service.getDevices()
    @PostMapping("/toggle/{id}") fun toggle(@PathVariable id: Long) = service.toggleDevice(id)
}
