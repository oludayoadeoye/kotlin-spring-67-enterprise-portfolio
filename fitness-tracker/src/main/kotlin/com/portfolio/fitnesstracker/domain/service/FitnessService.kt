package com.portfolio.fitnesstracker.domain.service

import com.portfolio.fitnesstracker.domain.model.Workout
import org.springframework.stereotype.Service

@Service
class FitnessService {
    private val workouts = mutableListOf<Workout>()

    fun getAll(): List<Workout> = workouts
    fun logWorkout(workout: Workout): Workout {
        val newWorkout = workout.copy(id = (workouts.size + 1).toLong())
        workouts.add(newWorkout)
        return newWorkout
    }
}
