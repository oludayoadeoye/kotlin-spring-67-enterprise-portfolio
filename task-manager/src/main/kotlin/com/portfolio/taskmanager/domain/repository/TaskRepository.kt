package com.portfolio.taskmanager.domain.repository

import com.portfolio.taskmanager.domain.model.Task

interface TaskRepository {
    suspend fun findAll(): List<Task>
    suspend fun findById(id: Long): Task?
    suspend fun save(task: Task): Task
    suspend fun deleteById(id: Long)
}
