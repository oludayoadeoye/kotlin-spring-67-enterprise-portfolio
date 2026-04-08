package com.portfolio.digitalclock.domain.model

import java.time.LocalDateTime

data class TimeResponse(
    val id: Long? = null,
    val city: String,
    val currentTime: String,
    val timeZone: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
