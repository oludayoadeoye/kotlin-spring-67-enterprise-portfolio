package com.portfolio.restaurantres.domain.repository

import com.portfolio.restaurantres.domain.model.Reservation

interface ReservationRepository {
    suspend fun findAll(): List<Reservation>
    suspend fun findById(id: Long): Reservation?
    suspend fun save(res: Reservation): Reservation
    suspend fun deleteById(id: Long)
}
