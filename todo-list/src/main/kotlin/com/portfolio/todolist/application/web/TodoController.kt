package com.portfolio.todolist.application.web

import com.portfolio.todolist.application.dto.TodoRequest
import com.portfolio.todolist.application.dto.TodoResponse
import com.portfolio.todolist.domain.service.TodoService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
@Tag(name = "TODO", description = "Endpoints for managing TODO items")
class TodoController(private val todoService: TodoService) {

    @GetMapping
    @Operation(summary = "List all TODOs")
    suspend fun getAllTodos(): List<TodoResponse> =
        todoService.getAllTodos().map { TodoResponse.fromDomain(it) }

    @GetMapping("/{id}")
    @Operation(summary = "Get TODO by ID")
    suspend fun getTodoById(@PathVariable id: Long): ResponseEntity<TodoResponse> {
        val todo = todoService.getTodoById(id)
        return if (todo != null) {
            ResponseEntity.ok(TodoResponse.fromDomain(todo))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new TODO")
    suspend fun createTodo(@Valid @RequestBody request: TodoRequest): TodoResponse {
        val createdTodo = todoService.createTodo(request.toDomain())
        return TodoResponse.fromDomain(createdTodo)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing TODO")
    suspend fun updateTodo(
        @PathVariable id: Long,
        @Valid @RequestBody request: TodoRequest
    ): ResponseEntity<TodoResponse> {
        val updatedTodo = todoService.updateTodo(id, request.toDomain())
        return if (updatedTodo != null) {
            ResponseEntity.ok(TodoResponse.fromDomain(updatedTodo))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a TODO")
    suspend fun deleteTodo(@PathVariable id: Long) {
        todoService.deleteTodo(id)
    }
}
