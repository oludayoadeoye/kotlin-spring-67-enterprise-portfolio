package com.portfolio.arapp.infrastructure.persistence

import com.portfolio.arapp.domain.model.ARAnchor
import com.portfolio.arapp.domain.repository.ARRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "ar_anchors")
class ARAnchorEntity(
    @Id
    val id: String,
    val x: Double,
    val y: Double,
    val z: Double,
    val asset: String
) {
    fun toDomain() = ARAnchor(id, x, y, z, asset)
    companion object {
        fun fromDomain(a: ARAnchor) = ARAnchorEntity(a.id, a.x, a.y, a.z, a.asset)
    }
}

interface SpringDataARRepository : JpaRepository<ARAnchorEntity, String>

@Repository
class JpaARRepositoryAdapter(private val repository: SpringDataARRepository) : ARRepository {
    override suspend fun findAll(): List<ARAnchor> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(anchor: ARAnchor): ARAnchor = withContext(Dispatchers.IO) {
        repository.save(ARAnchorEntity.fromDomain(anchor)).toDomain()
    }
}
