package com.portfolio.taskmanager.infrastructure.persistence

import com.portfolio.taskmanager.domain.model.Task
import com.portfolio.taskmanager.domain.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tasks")
class TaskEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val description: String?,
    val priority: Int = 3,
    val status: String = "TODO",
    val deadline: LocalDateTime?,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Task(id, title, description, priority, status, deadline, createdAt)
    companion object {
        fun fromDomain(t: Task) = TaskEntity(t.id, t.title, t.description, t.priority, t.status, t.deadline, t.createdAt)
    }
}

interface SpringDataTaskRepository : JpaRepository<TaskEntity, Long>

@Repository
class JpaTaskRepositoryAdapter(private val repository: SpringDataTaskRepository) : TaskRepository {
    override suspend fun findAll(): List<Task> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Task? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(task: Task): Task = withContext(Dispatchers.IO) {
        repository.save(TaskEntity.fromDomain(task)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
