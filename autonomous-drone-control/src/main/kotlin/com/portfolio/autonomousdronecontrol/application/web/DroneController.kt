package com.portfolio.autonomousdronecontrol.application.web

import com.portfolio.autonomousdronecontrol.domain.service.DroneService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/drone")
class DroneController(private val service: DroneService) {
    @GetMapping("/telemetry") fun telemetry() = service.getTelemetry()
    @PostMapping("/command") fun command(@RequestBody cmd: String) = service.sendCommand(cmd)
}
