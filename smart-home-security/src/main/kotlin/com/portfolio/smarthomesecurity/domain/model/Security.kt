package com.portfolio.smarthomesecurity.domain.model

data class SecurityStatus(
    val alarmsArmed: Boolean,
    val camerasActive: Int,
    val intrudersDetected: Boolean = false
)
