package com.portfolio.autonomousdronecontrol.application.web

import com.portfolio.autonomousdronecontrol.domain.model.DroneTelemetry
import com.portfolio.autonomousdronecontrol.domain.service.DroneService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/drone")
@Tag(name = "Drone", description = "Autonomous drone telemetry endpoints")
class DroneController(private val service: DroneService) {
    @GetMapping("/telemetry/latest") suspend fun latest() = service.getLatestTelemetry()
    @PostMapping("/telemetry") suspend fun log(@RequestBody t: DroneTelemetry) = service.logTelemetry(t)
    @GetMapping("/telemetry/history") suspend fun history() = service.getAllHistory()
}
