package com.portfolio.calculator.domain.model

import java.time.LocalDateTime

data class Calculation(
    val id: Long? = null,
    val expression: String,
    val result: Double,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
