package com.portfolio.restaurantres.infrastructure.persistence

import com.portfolio.restaurantres.domain.model.Reservation
import com.portfolio.restaurantres.domain.repository.ReservationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "reservations")
class ReservationEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val customerName: String,
    val tableNumber: Int,
    val dateTime: LocalDateTime,
    val guests: Int
) {
    fun toDomain() = Reservation(id, customerName, tableNumber, dateTime, guests)
    companion object {
        fun fromDomain(r: Reservation) = ReservationEntity(r.id, r.customerName, r.tableNumber, r.dateTime, r.guests)
    }
}

interface SpringDataReservationRepository : JpaRepository<ReservationEntity, Long>

@Repository
class JpaReservationRepositoryAdapter(private val repository: SpringDataReservationRepository) : ReservationRepository {
    override suspend fun findAll(): List<Reservation> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Reservation? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(res: Reservation): Reservation = withContext(Dispatchers.IO) {
        repository.save(ReservationEntity.fromDomain(res)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
