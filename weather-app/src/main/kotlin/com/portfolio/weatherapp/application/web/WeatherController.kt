package com.portfolio.weatherapp.application.web

import com.portfolio.weatherapp.application.dto.WeatherRequest
import com.portfolio.weatherapp.application.dto.WeatherResponse
import com.portfolio.weatherapp.domain.service.WeatherService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/weather")
@Tag(name = "Weather", description = "Endpoints for weather data management")
class WeatherController(private val weatherService: WeatherService) {

    @GetMapping
    @Operation(summary = "List all weather records")
    suspend fun getAll(): List<WeatherResponse> = weatherService.getAllHistory().map { WeatherResponse.fromDomain(it) }

    @GetMapping("/{id}")
    @Operation(summary = "Get record by ID")
    suspend fun getById(@PathVariable id: Long): ResponseEntity<WeatherResponse> =
        weatherService.getById(id)?.let { ResponseEntity.ok(WeatherResponse.fromDomain(it)) } 
            ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Log new weather data")
    suspend fun create(@Valid @RequestBody request: WeatherRequest): WeatherResponse =
        WeatherResponse.fromDomain(weatherService.createRecord(request.toDomain()))

    @PutMapping("/{id}")
    @Operation(summary = "Update weather record")
    suspend fun update(@PathVariable id: Long, @Valid @RequestBody request: WeatherRequest): ResponseEntity<WeatherResponse> =
        weatherService.updateRecord(id, request.toDomain())?.let { ResponseEntity.ok(WeatherResponse.fromDomain(it)) }
            ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete record")
    suspend fun delete(@PathVariable id: Long) {
        weatherService.deleteRecord(id)
    }
}
