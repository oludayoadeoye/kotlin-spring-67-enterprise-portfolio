package com.portfolio.digitalclock.domain.repository

import com.portfolio.digitalclock.domain.model.TimeResponse

interface ClockRepository {
    suspend fun save(time: TimeResponse): TimeResponse
    suspend fun findAll(): List<TimeResponse>
}
