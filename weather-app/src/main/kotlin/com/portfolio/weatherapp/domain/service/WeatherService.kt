package com.portfolio.weatherapp.domain.service

import com.portfolio.weatherapp.domain.model.Weather
import com.portfolio.weatherapp.domain.repository.WeatherRepository
import org.springframework.stereotype.Service

@Service
class WeatherService(private val weatherRepository: WeatherRepository) {
    fun getWeather(city: String): Weather {
        // In a real app, this would call an external API adapter first
        // For this deep logic portfolio, we'll simulate the fetch logic
        val latest = weatherRepository.findLatestByCity(city)
        return latest ?: createInitialWeather(city)
    }

    private fun createInitialWeather(city: String): Weather {
        val simulatedWeather = Weather(
            city = city,
            temperature = 22.5,
            condition = "Sunny",
            humidity = 45
        )
        return weatherRepository.save(simulatedWeather)
    }

    fun getAllHistory(): List<Weather> = weatherRepository.findAll()
}
