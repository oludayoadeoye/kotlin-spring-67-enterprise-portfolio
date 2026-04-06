package com.portfolio.eventmanagement.domain.model

import java.time.LocalDateTime

data class Event(
    val id: Long? = null,
    val name: String,
    val location: String,
    val dateTime: LocalDateTime,
    val organizer: String
)
