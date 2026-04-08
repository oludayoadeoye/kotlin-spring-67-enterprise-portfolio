package com.portfolio.smarthomesecurity.domain.repository

import com.portfolio.smarthomesecurity.domain.model.SecurityEvent

interface SecurityRepository {
    suspend fun save(event: SecurityEvent): SecurityEvent
    suspend fun findAll(): List<SecurityEvent>
}
