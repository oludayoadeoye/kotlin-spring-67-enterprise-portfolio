package com.portfolio.weatherapp.infrastructure.persistence

import com.portfolio.weatherapp.domain.model.Weather
import com.portfolio.weatherapp.domain.repository.WeatherRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataWeatherRepository : JpaRepository<WeatherEntity, Long> {
    fun findFirstByCityOrderByTimestampDesc(city: String): WeatherEntity?
}

@Repository
class JpaWeatherRepositoryAdapter(private val repository: SpringDataWeatherRepository) : WeatherRepository {
    override fun findLatestByCity(city: String): Weather? = 
        repository.findFirstByCityOrderByTimestampDesc(city)?.toDomain()

    override fun save(weather: Weather): Weather = 
        repository.save(WeatherEntity.fromDomain(weather)).toDomain()

    override fun findAll(): List<Weather> = 
        repository.findAll().map { it.toDomain() }
}
