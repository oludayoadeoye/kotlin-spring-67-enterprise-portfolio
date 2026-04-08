package com.portfolio.homeautomation.infrastructure.persistence

import com.portfolio.homeautomation.domain.model.Device
import com.portfolio.homeautomation.domain.repository.AutomationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "devices")
class DeviceEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val type: String,
    val status: String = "Off"
) {
    fun toDomain() = Device(id, name, type, status)
    companion object {
        fun fromDomain(d: Device) = DeviceEntity(d.id, d.name, d.type, d.status)
    }
}

interface SpringDataAutomationRepository : JpaRepository<DeviceEntity, Long>

@Repository
class JpaAutomationRepositoryAdapter(private val repository: SpringDataAutomationRepository) : AutomationRepository {
    override suspend fun findAll(): List<Device> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Device? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(device: Device): Device = withContext(Dispatchers.IO) {
        repository.save(DeviceEntity.fromDomain(device)).toDomain()
    }
}
