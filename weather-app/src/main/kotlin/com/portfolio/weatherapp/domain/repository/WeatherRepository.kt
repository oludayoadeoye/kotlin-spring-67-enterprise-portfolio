package com.portfolio.weatherapp.domain.repository

import com.portfolio.weatherapp.domain.model.Weather

interface WeatherRepository {
    fun findLatestByCity(city: String): Weather?
    fun save(weather: Weather): Weather
    fun findAll(): List<Weather>
}
