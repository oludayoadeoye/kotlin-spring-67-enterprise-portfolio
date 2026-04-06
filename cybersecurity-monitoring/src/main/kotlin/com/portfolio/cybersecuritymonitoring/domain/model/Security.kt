package com.portfolio.cybersecuritymonitoring.domain.model

import java.time.LocalDateTime

data class ThreatAlert(
    val id: String,
    val severity: String, // "Low", "Medium", "High", "Critical"
    val sourceIp: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
