package com.portfolio.unitconverter.infrastructure.persistence

import com.portfolio.unitconverter.domain.model.ConversionRecord
import com.portfolio.unitconverter.domain.repository.ConversionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "conversion_history")
class ConversionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val fromValue: Double,
    val fromUnit: String,
    val toValue: Double,
    val toUnit: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = ConversionRecord(id, fromValue, fromUnit, toValue, toUnit, timestamp)
    companion object {
        fun fromDomain(r: ConversionRecord) = ConversionEntity(r.id, r.fromValue, r.fromUnit, r.toValue, r.toUnit, r.timestamp)
    }
}

interface SpringDataConversionRepository : JpaRepository<ConversionEntity, Long>

@Repository
class JpaConversionRepositoryAdapter(private val repository: SpringDataConversionRepository) : ConversionRepository {
    override suspend fun save(record: ConversionRecord): ConversionRecord = withContext(Dispatchers.IO) {
        repository.save(ConversionEntity.fromDomain(record)).toDomain()
    }
    override suspend fun findAll(): List<ConversionRecord> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
