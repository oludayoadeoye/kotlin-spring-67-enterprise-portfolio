package com.portfolio.cybersecuritymonitoring.domain.service

import com.portfolio.cybersecuritymonitoring.domain.model.ThreatAlert
import com.portfolio.cybersecuritymonitoring.domain.repository.SecurityRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MonitoringService(private val repository: SecurityRepository) {
    suspend fun getActiveAlerts(): List<ThreatAlert> = repository.findAll()
    
    suspend fun logAlert(severity: String, ip: String): ThreatAlert {
        val alert = ThreatAlert(UUID.randomUUID().toString(), severity, ip)
        return repository.save(alert)
    }
}
