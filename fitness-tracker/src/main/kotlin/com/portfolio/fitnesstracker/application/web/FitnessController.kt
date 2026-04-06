package com.portfolio.fitnesstracker.application.web

import com.portfolio.fitnesstracker.domain.model.Workout
import com.portfolio.fitnesstracker.domain.service.FitnessService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/fitness")
class FitnessController(private val service: FitnessService) {
    @GetMapping("/workouts") fun list() = service.getAll()
    @PostMapping("/log") fun log(@RequestBody workout: Workout) = service.logWorkout(workout)
}
