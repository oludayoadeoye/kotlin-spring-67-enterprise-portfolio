package com.portfolio.taskmanager.domain.service

import com.portfolio.taskmanager.domain.model.Task
import org.springframework.stereotype.Service

@Service
class TaskService {
    private val tasks = mutableListOf<Task>()

    fun getAll(): List<Task> = tasks.sortedByDescending { it.priority }
    fun create(task: Task): Task {
        val newTask = task.copy(id = (tasks.size + 1).toLong())
        tasks.add(newTask)
        return newTask
    }
}
