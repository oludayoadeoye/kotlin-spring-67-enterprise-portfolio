package com.portfolio.fitnesstracker.domain.repository

import com.portfolio.fitnesstracker.domain.model.Workout

interface FitnessRepository {
    suspend fun findAll(): List<Workout>
    suspend fun save(workout: Workout): Workout
    suspend fun findById(id: Long): Workout?
    suspend fun deleteById(id: Long)
}
