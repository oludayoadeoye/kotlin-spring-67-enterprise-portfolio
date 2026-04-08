package com.portfolio.eventmanagement.infrastructure.persistence

import com.portfolio.eventmanagement.domain.model.Event
import com.portfolio.eventmanagement.domain.repository.EventRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "events")
class EventEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val location: String,
    val dateTime: LocalDateTime,
    val organizer: String
) {
    fun toDomain() = Event(id, name, location, dateTime, organizer)
    companion object {
        fun fromDomain(e: Event) = EventEntity(e.id, e.name, e.location, e.dateTime, e.organizer)
    }
}

interface SpringDataEventRepository : JpaRepository<EventEntity, Long>

@Repository
class JpaEventRepositoryAdapter(private val repository: SpringDataEventRepository) : EventRepository {
    override suspend fun findAll(): List<Event> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Event? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(event: Event): Event = withContext(Dispatchers.IO) {
        repository.save(EventEntity.fromDomain(event)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
