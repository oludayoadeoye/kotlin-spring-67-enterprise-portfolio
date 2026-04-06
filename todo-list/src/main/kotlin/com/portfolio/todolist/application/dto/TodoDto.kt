package com.portfolio.todolist.application.dto

import com.portfolio.todolist.domain.model.Todo
import jakarta.validation.constraints.NotBlank
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(description = "Request to create or update a TODO item")
data class TodoRequest(
    @field:NotBlank(message = "Title is required")
    @field:Schema(description = "Title of the task", example = "Buy groceries")
    val title: String,

    @field:Schema(description = "Detailed description of the task", example = "Milk, Eggs, and Bread")
    val description: String?,

    @field:Schema(description = "Completion status", example = "false")
    val completed: Boolean = false
) {
    fun toDomain(): Todo = Todo(
        title = title,
        description = description,
        completed = completed
    )
}

@Schema(description = "Response representing a TODO item")
data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val completed: Boolean,
    val createdAt: LocalDateTime
) {
    companion object {
        fun fromDomain(todo: Todo): TodoResponse = TodoResponse(
            id = todo.id!!,
            title = todo.title,
            description = todo.description,
            completed = todo.completed,
            createdAt = todo.createdAt
        )
    }
}
