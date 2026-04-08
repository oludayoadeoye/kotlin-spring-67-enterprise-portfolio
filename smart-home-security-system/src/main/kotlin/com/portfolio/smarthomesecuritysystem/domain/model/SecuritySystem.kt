package com.portfolio.smarthomesecuritysystem.domain.model

data class SecurityZone(
    val zoneId: String,
    val status: String, // "Secure", "Triggered"
    val sensitivity: Double
)
