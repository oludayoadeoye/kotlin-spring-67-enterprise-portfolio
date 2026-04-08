package com.portfolio.smarthomesecurity.infrastructure.persistence

import com.portfolio.smarthomesecurity.domain.model.SecurityEvent
import com.portfolio.smarthomesecurity.domain.repository.SecurityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "security_events")
class SecurityEventEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val deviceId: String,
    val eventType: String,
    val severity: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = SecurityEvent(id, deviceId, eventType, severity, timestamp)
    companion object {
        fun fromDomain(e: SecurityEvent) = SecurityEventEntity(e.id, e.deviceId, e.eventType, e.severity, e.timestamp)
    }
}

interface SpringDataSecurityRepository : JpaRepository<SecurityEventEntity, Long>

@Repository
class JpaSecurityRepositoryAdapter(private val repository: SpringDataSecurityRepository) : SecurityRepository {
    override suspend fun save(event: SecurityEvent): SecurityEvent = withContext(Dispatchers.IO) {
        repository.save(SecurityEventEntity.fromDomain(event)).toDomain()
    }
    override suspend fun findAll(): List<SecurityEvent> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
