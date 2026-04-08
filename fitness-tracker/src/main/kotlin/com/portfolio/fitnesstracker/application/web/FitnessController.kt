package com.portfolio.fitnesstracker.application.web

import com.portfolio.fitnesstracker.domain.model.Workout
import com.portfolio.fitnesstracker.domain.service.FitnessService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/fitness")
@Tag(name = "Fitness", description = "Workout tracking endpoints")
class FitnessController(private val service: FitnessService) {
    @GetMapping("/workouts") suspend fun list() = service.getAll()
    @GetMapping("/workouts/{id}") suspend fun get(@PathVariable id: Long): ResponseEntity<Workout> =
        service.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    @PostMapping("/log") @ResponseStatus(HttpStatus.CREATED) suspend fun log(@RequestBody workout: Workout) = service.logWorkout(workout)
    @DeleteMapping("/workouts/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) suspend fun delete(@PathVariable id: Long) = service.delete(id)
}
