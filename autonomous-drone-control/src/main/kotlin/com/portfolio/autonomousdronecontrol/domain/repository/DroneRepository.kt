package com.portfolio.autonomousdronecontrol.domain.repository

import com.portfolio.autonomousdronecontrol.domain.model.DroneTelemetry

interface DroneRepository {
    suspend fun save(telemetry: DroneTelemetry): DroneTelemetry
    suspend fun findLatest(): DroneTelemetry?
    suspend fun findAll(): List<DroneTelemetry>
}
