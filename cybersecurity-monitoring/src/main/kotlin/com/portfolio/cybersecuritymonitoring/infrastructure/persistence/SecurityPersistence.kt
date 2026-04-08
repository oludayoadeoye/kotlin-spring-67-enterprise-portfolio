package com.portfolio.cybersecuritymonitoring.infrastructure.persistence

import com.portfolio.cybersecuritymonitoring.domain.model.ThreatAlert
import com.portfolio.cybersecuritymonitoring.domain.repository.SecurityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "threat_alerts")
class ThreatEntity(
    @Id
    val id: String,
    val severity: String,
    val sourceIp: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = ThreatAlert(id, severity, sourceIp, timestamp)
    companion object {
        fun fromDomain(t: ThreatAlert) = ThreatEntity(t.id, t.severity, t.sourceIp, t.timestamp)
    }
}

interface SpringDataSecurityRepository : JpaRepository<ThreatEntity, String>

@Repository
class JpaSecurityRepositoryAdapter(private val repository: SpringDataSecurityRepository) : SecurityRepository {
    override suspend fun save(alert: ThreatAlert): ThreatAlert = withContext(Dispatchers.IO) {
        repository.save(ThreatEntity.fromDomain(alert)).toDomain()
    }
    override suspend fun findAll(): List<ThreatAlert> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
