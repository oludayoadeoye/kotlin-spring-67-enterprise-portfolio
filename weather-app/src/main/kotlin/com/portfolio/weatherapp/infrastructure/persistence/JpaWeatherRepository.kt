package com.portfolio.weatherapp.infrastructure.persistence

import com.portfolio.weatherapp.domain.model.Weather
import com.portfolio.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataWeatherRepository : JpaRepository<WeatherEntity, Long> {
    fun findFirstByCityOrderByTimestampDesc(city: String): WeatherEntity?
}

@Repository
class JpaWeatherRepositoryAdapter(private val repository: SpringDataWeatherRepository) : WeatherRepository {
    override suspend fun findLatestByCity(city: String): Weather? = withContext(Dispatchers.IO) {
        repository.findFirstByCityOrderByTimestampDesc(city)?.toDomain()
    }

    override suspend fun findById(id: Long): Weather? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override suspend fun save(weather: Weather): Weather = withContext(Dispatchers.IO) {
        repository.save(WeatherEntity.fromDomain(weather)).toDomain()
    }

    override suspend fun findAll(): List<Weather> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }

    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
