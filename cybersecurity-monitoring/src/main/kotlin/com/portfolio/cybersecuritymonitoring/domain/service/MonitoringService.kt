package com.portfolio.cybersecuritymonitoring.domain.service

import com.portfolio.cybersecuritymonitoring.domain.model.ThreatAlert
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MonitoringService {
    fun getActiveAlerts(): List<ThreatAlert> = listOf(
        ThreatAlert(UUID.randomUUID().toString(), "High", "192.168.1.50"),
        ThreatAlert(UUID.randomUUID().toString(), "Critical", "10.0.0.120")
    )
}
