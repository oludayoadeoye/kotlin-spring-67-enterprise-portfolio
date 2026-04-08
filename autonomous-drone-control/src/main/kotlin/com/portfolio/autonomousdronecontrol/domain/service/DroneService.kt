package com.portfolio.autonomousdronecontrol.domain.service

import com.portfolio.autonomousdronecontrol.domain.model.DroneTelemetry
import com.portfolio.autonomousdronecontrol.domain.repository.DroneRepository
import io.mavsdk.System
import org.springframework.stereotype.Service
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Service
class DroneService(private val repository: DroneRepository) {
    
    // In a real production environment, we connect to a real drone/simulator
    // private val drone = System("localhost", 50051)

    suspend fun getLatestTelemetry(): DroneTelemetry? = repository.findLatest()

    suspend fun takeoff(): String {
        // Simulated MAVSDK Action
        // drone.action.takeoff().subscribe()
        return "Drone takeoff command sent to MAVSDK-Server."
    }

    suspend fun logTelemetry(telemetry: DroneTelemetry): DroneTelemetry = repository.save(telemetry)
    
    suspend fun getAllHistory(): List<DroneTelemetry> = repository.findAll()
}
