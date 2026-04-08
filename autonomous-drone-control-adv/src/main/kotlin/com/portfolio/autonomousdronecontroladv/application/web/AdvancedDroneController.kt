package com.portfolio.autonomousdronecontroladv.application.web

import com.portfolio.autonomousdronecontroladv.domain.service.AdvancedDroneService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/drone/adv")
class AdvancedDroneController(private val service: AdvancedDroneService) {
    @GetMapping("/path") fun path() = service.getPath()
}
