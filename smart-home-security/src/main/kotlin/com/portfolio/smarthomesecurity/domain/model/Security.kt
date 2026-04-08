package com.portfolio.smarthomesecurity.domain.model

import java.time.LocalDateTime

data class SecurityEvent(
    val id: Long? = null,
    val deviceId: String,
    val eventType: String,
    val severity: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

data class SecurityStatus(
    val alarmsArmed: Boolean,
    val camerasActive: Int,
    val intrudersDetected: Boolean = false
)
