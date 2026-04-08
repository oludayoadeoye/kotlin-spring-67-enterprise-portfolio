package com.portfolio.digitalclock.domain.service

import com.portfolio.digitalclock.domain.model.TimeResponse
import com.portfolio.digitalclock.domain.repository.ClockRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ClockService(private val repository: ClockRepository) {
    suspend fun getCurrentTime(): TimeResponse {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val response = TimeResponse(city = "UTC", currentTime = now.format(formatter), timeZone = "UTC")
        return repository.save(response)
    }

    suspend fun getHistory(): List<TimeResponse> = repository.findAll()
}
