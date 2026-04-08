package com.portfolio.autonomousdronecontrol.infrastructure.persistence

import com.portfolio.autonomousdronecontrol.domain.model.DroneTelemetry
import com.portfolio.autonomousdronecontrol.domain.repository.DroneRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "drone_telemetry")
class DroneEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val batteryLevel: Double,
    val altitude: Double,
    val velocity: Double,
    val status: String = "Stable",
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = DroneTelemetry(id, batteryLevel, altitude, velocity, status, timestamp)
    companion object {
        fun fromDomain(d: DroneTelemetry) = DroneEntity(d.id, d.batteryLevel, d.altitude, d.velocity, d.status, d.timestamp)
    }
}

interface SpringDataDroneRepository : JpaRepository<DroneEntity, Long> {
    fun findFirstByOrderByTimestampDesc(): DroneEntity?
}

@Repository
class JpaDroneRepositoryAdapter(private val repository: SpringDataDroneRepository) : DroneRepository {
    override suspend fun save(telemetry: DroneTelemetry): DroneTelemetry = withContext(Dispatchers.IO) {
        repository.save(DroneEntity.fromDomain(telemetry)).toDomain()
    }
    override suspend fun findLatest(): DroneTelemetry? = withContext(Dispatchers.IO) {
        repository.findFirstByOrderByTimestampDesc()?.toDomain()
    }
    override suspend fun findAll(): List<DroneTelemetry> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
