package com.portfolio.autonomousdronecontrol.domain.model

data class DroneTelemetry(
    val batteryLevel: Double,
    val altitude: Double,
    val velocity: Double,
    val status: String = "Stable"
)
