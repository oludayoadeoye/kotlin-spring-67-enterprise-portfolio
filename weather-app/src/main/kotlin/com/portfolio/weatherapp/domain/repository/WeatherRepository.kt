package com.portfolio.weatherapp.domain.repository

import com.portfolio.weatherapp.domain.model.Weather

interface WeatherRepository {
    suspend fun findLatestByCity(city: String): Weather?
    suspend fun findById(id: Long): Weather?
    suspend fun save(weather: Weather): Weather
    suspend fun findAll(): List<Weather>
    suspend fun deleteById(id: Long)
}
