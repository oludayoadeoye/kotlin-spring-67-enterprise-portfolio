package com.portfolio.weatherapp.domain.model

import java.time.LocalDateTime

data class Weather(
    val id: Long? = null,
    val city: String,
    val temperature: Double,
    val condition: String,
    val humidity: Int,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
