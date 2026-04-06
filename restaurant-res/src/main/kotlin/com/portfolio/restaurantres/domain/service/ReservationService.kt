package com.portfolio.restaurantres.domain.service

import com.portfolio.restaurantres.domain.model.Reservation
import org.springframework.stereotype.Service

@Service
class ReservationService {
    private val reservations = mutableListOf<Reservation>()

    fun getAll(): List<Reservation> = reservations
    fun book(res: Reservation): Reservation {
        val newRes = res.copy(id = (reservations.size + 1).toLong())
        reservations.add(newRes)
        return newRes
    }
}
