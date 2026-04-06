package com.portfolio.weatherapp.application.web

import com.portfolio.weatherapp.domain.model.Weather
import com.portfolio.weatherapp.domain.service.WeatherService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/weather")
@Tag(name = "Weather", description = "Endpoints for fetching weather data")
class WeatherController(private val weatherService: WeatherService) {

    @GetMapping("/{city}")
    @Operation(summary = "Get current weather for a city")
    fun getWeather(@PathVariable city: String): Weather = weatherService.getWeather(city)

    @GetMapping("/history")
    @Operation(summary = "Get all weather fetch history")
    fun getHistory(): List<Weather> = weatherService.getAllHistory()
}
