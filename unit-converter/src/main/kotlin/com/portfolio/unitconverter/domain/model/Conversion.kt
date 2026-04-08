package com.portfolio.unitconverter.domain.model

import java.time.LocalDateTime

data class ConversionRecord(
    val id: Long? = null,
    val fromValue: Double,
    val fromUnit: String,
    val toValue: Double,
    val toUnit: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
