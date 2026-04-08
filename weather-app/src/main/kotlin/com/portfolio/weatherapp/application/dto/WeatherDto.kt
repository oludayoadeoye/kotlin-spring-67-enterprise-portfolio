package com.portfolio.weatherapp.application.dto

import com.portfolio.weatherapp.domain.model.Weather
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class WeatherRequest(
    @field:NotBlank(message = "City is required")
    val city: String,
    val temperature: Double,
    val condition: String,
    val humidity: Int
) {
    fun toDomain() = Weather(city = city, temperature = temperature, condition = condition, humidity = humidity)
}

data class WeatherResponse(
    val id: Long,
    val city: String,
    val temperature: Double,
    val condition: String,
    val humidity: Int,
    val timestamp: LocalDateTime
) {
    companion object {
        fun fromDomain(w: Weather) = WeatherResponse(w.id!!, w.city, w.temperature, w.condition, w.humidity, w.timestamp)
    }
}
