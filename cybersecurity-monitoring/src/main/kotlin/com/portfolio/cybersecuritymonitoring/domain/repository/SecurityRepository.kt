package com.portfolio.cybersecuritymonitoring.domain.repository

import com.portfolio.cybersecuritymonitoring.domain.model.ThreatAlert

interface SecurityRepository {
    suspend fun save(alert: ThreatAlert): ThreatAlert
    suspend fun findAll(): List<ThreatAlert>
}
