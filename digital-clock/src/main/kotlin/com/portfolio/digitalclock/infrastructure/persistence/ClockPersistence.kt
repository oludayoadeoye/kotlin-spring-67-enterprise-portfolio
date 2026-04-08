package com.portfolio.digitalclock.infrastructure.persistence

import com.portfolio.digitalclock.domain.model.TimeResponse
import com.portfolio.digitalclock.domain.repository.ClockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "clock_fetches")
class ClockEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val city: String,
    val time: String,
    @Column(name = "offset_val")
    val timeZone: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = TimeResponse(id, city, time, timeZone, timestamp)
    companion object {
        fun fromDomain(t: TimeResponse) = ClockEntity(t.id, t.city, t.currentTime, t.timeZone, t.timestamp)
    }
}

interface SpringDataClockRepository : JpaRepository<ClockEntity, Long>

@Repository
class JpaClockRepositoryAdapter(private val repository: SpringDataClockRepository) : ClockRepository {
    override suspend fun save(time: TimeResponse): TimeResponse = withContext(Dispatchers.IO) {
        repository.save(ClockEntity.fromDomain(time)).toDomain()
    }
    override suspend fun findAll(): List<TimeResponse> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
