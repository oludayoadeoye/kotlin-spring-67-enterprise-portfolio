package com.portfolio.weatherapp.infrastructure.persistence

import com.portfolio.weatherapp.domain.model.Weather
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "weather_history")
class WeatherEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val city: String,
    val temperature: Double,
    val condition: String,
    val humidity: Int,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Weather(id, city, temperature, condition, humidity, timestamp)

    companion object {
        fun fromDomain(w: Weather) = WeatherEntity(w.id, w.city, w.temperature, w.condition, w.humidity, w.timestamp)
    }
}
