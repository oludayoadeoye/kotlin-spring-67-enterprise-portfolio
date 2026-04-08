package com.portfolio.fitnesstracker.infrastructure.persistence

import com.portfolio.fitnesstracker.domain.model.Workout
import com.portfolio.fitnesstracker.domain.repository.FitnessRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "workouts")
class WorkoutEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val type: String,
    val durationMinutes: Int,
    val caloriesBurned: Int,
    val date: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Workout(id, type, durationMinutes, caloriesBurned, date)
    companion object {
        fun fromDomain(w: Workout) = WorkoutEntity(w.id, w.type, w.durationMinutes, w.caloriesBurned, w.date)
    }
}

interface SpringDataFitnessRepository : JpaRepository<WorkoutEntity, Long>

@Repository
class JpaFitnessRepositoryAdapter(private val repository: SpringDataFitnessRepository) : FitnessRepository {
    override suspend fun findAll(): List<Workout> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(workout: Workout): Workout = withContext(Dispatchers.IO) {
        repository.save(WorkoutEntity.fromDomain(workout)).toDomain()
    }
    override suspend fun findById(id: Long): Workout? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
