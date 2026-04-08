package com.portfolio.taskmanager.application.web

import com.portfolio.taskmanager.domain.model.Task
import com.portfolio.taskmanager.domain.service.TaskService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks", description = "Endpoints for task management")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    suspend fun list() = taskService.getAll()

    @GetMapping("/{id}")
    suspend fun get(@PathVariable id: Long): ResponseEntity<Task> =
        taskService.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(@RequestBody task: Task) = taskService.create(task)

    @PutMapping("/{id}")
    suspend fun update(@PathVariable id: Long, @RequestBody task: Task): ResponseEntity<Task> =
        taskService.update(id, task)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun delete(@PathVariable id: Long) = taskService.delete(id)
}
