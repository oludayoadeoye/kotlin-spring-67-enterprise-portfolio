package com.portfolio.restaurantres.domain.model

import java.time.LocalDateTime

data class Reservation(
    val id: Long? = null,
    val customerName: String,
    val tableNumber: Int,
    val dateTime: LocalDateTime,
    val guests: Int
)
