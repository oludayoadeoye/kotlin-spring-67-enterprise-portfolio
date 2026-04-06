package com.portfolio.digitalclock.domain.service

import com.portfolio.digitalclock.domain.model.TimeResponse
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ClockService {
    fun getCurrentTime(): TimeResponse {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        return TimeResponse(now.format(formatter), "UTC")
    }
}
