package com.portfolio.fitnesstracker.domain.model

import java.time.LocalDateTime

data class Workout(
    val id: Long? = null,
    val type: String, // e.g., "Running", "Yoga"
    val durationMinutes: Int,
    val caloriesBurned: Int,
    val date: LocalDateTime = LocalDateTime.now()
)
