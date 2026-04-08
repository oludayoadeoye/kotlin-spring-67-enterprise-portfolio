package com.portfolio.autonomousdronecontrol.domain.model

import java.time.LocalDateTime

data class DroneTelemetry(
    val id: Long? = null,
    val batteryLevel: Double,
    val altitude: Double,
    val velocity: Double,
    val status: String = "Stable",
    val timestamp: LocalDateTime = LocalDateTime.now()
)
