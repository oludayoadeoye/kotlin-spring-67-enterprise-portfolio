package com.portfolio.autonomousdronecontrol.domain.service

import com.portfolio.autonomousdronecontrol.domain.model.DroneTelemetry
import org.springframework.stereotype.Service

@Service
class DroneService {
    fun getTelemetry(): DroneTelemetry = DroneTelemetry(85.5, 120.0, 15.0)
    fun sendCommand(command: String): String = "Command '$command' executed successfully."
}
