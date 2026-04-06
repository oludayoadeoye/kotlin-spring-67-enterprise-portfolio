package com.portfolio.taskmanager.application.web

import com.portfolio.taskmanager.domain.model.Task
import com.portfolio.taskmanager.domain.service.TaskService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val taskService: TaskService) {
    @GetMapping fun list() = taskService.getAll()
    @PostMapping fun create(@RequestBody task: Task) = taskService.create(task)
}
