package com.portfolio.restaurantres.domain.service

import com.portfolio.restaurantres.domain.model.Reservation
import com.portfolio.restaurantres.domain.repository.ReservationRepository
import org.springframework.stereotype.Service

@Service
class ReservationService(private val repository: ReservationRepository) {
    suspend fun getAll(): List<Reservation> = repository.findAll()
    suspend fun getById(id: Long): Reservation? = repository.findById(id)
    suspend fun book(res: Reservation): Reservation = repository.save(res)
    suspend fun update(id: Long, updated: Reservation): Reservation? {
        val existing = repository.findById(id) ?: return null
        return repository.save(updated.copy(id = existing.id))
    }
    suspend fun delete(id: Long) = repository.deleteById(id)
}
