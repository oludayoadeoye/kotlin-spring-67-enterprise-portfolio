package com.portfolio.weatherapp.domain.service

import com.portfolio.weatherapp.domain.model.Weather
import com.portfolio.weatherapp.domain.repository.WeatherRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class WeatherService(private val weatherRepository: WeatherRepository) {
    suspend fun getAllHistory(): List<Weather> = weatherRepository.findAll()

    suspend fun getById(id: Long): Weather? = weatherRepository.findById(id)

    suspend fun createRecord(weather: Weather): Weather = weatherRepository.save(weather)

    suspend fun updateRecord(id: Long, updated: Weather): Weather? {
        val existing = weatherRepository.findById(id) ?: return null
        return weatherRepository.save(updated.copy(id = existing.id, timestamp = LocalDateTime.now()))
    }

    suspend fun deleteRecord(id: Long) = weatherRepository.deleteById(id)
}
