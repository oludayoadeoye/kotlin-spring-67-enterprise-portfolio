package com.portfolio.smarthomesecurity.domain.service

import com.portfolio.smarthomesecurity.domain.model.SecurityEvent
import com.portfolio.smarthomesecurity.domain.model.SecurityStatus
import com.portfolio.smarthomesecurity.domain.repository.SecurityRepository
import org.springframework.stereotype.Service

@Service
class SecurityService(private val repository: SecurityRepository) {
    suspend fun getStatus(): SecurityStatus = SecurityStatus(true, 8, false)
    suspend fun logEvent(event: SecurityEvent): SecurityEvent = repository.save(event)
    suspend fun getEventHistory(): List<SecurityEvent> = repository.findAll()
}
