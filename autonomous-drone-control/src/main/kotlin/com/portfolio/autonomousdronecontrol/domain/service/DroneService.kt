package com.portfolio.autonomousdronecontrol.domain.service

import com.portfolio.autonomousdronecontrol.domain.model.DroneTelemetry
import com.portfolio.autonomousdronecontrol.domain.repository.DroneRepository
import org.springframework.stereotype.Service

@Service
class DroneService(private val repository: DroneRepository) {
    suspend fun getLatestTelemetry(): DroneTelemetry? = repository.findLatest()
    suspend fun logTelemetry(telemetry: DroneTelemetry): DroneTelemetry = repository.save(telemetry)
    suspend fun getAllHistory(): List<DroneTelemetry> = repository.findAll()
}
