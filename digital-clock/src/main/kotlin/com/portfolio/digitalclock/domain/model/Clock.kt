package com.portfolio.digitalclock.domain.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class TimeResponse(
    val currentTime: String,
    val timeZone: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
