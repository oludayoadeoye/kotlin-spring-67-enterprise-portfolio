package com.portfolio.taskmanager.domain.service

import com.portfolio.taskmanager.domain.model.Task
import com.portfolio.taskmanager.domain.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val repository: TaskRepository) {
    suspend fun getAll(): List<Task> = repository.findAll()
    suspend fun getById(id: Long): Task? = repository.findById(id)
    suspend fun create(task: Task): Task = repository.save(task)
    suspend fun update(id: Long, updated: Task): Task? {
        val existing = repository.findById(id) ?: return null
        return repository.save(updated.copy(id = existing.id, createdAt = existing.createdAt))
    }
    suspend fun delete(id: Long) = repository.deleteById(id)
}
