package com.portfolio.cybersecuritymonitoring.domain.model

import java.time.LocalDateTime

data class ThreatAlert(
    val id: String,
    val severity: String,
    val sourceIp: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
