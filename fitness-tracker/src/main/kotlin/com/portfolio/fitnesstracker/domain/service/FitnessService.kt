package com.portfolio.fitnesstracker.domain.service

import com.portfolio.fitnesstracker.domain.model.Workout
import com.portfolio.fitnesstracker.domain.repository.FitnessRepository
import org.springframework.stereotype.Service

@Service
class FitnessService(private val repository: FitnessRepository) {
    suspend fun getAll(): List<Workout> = repository.findAll()
    suspend fun logWorkout(workout: Workout): Workout = repository.save(workout)
    suspend fun getById(id: Long): Workout? = repository.findById(id)
    suspend fun delete(id: Long) = repository.deleteById(id)
}
