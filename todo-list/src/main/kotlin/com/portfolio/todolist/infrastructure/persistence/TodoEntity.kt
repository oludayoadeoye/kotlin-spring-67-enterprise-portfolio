package com.portfolio.todolist.infrastructure.persistence

import com.portfolio.todolist.domain.model.Todo
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "todos")
class TodoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val title: String,

    val description: String?,

    @Column(nullable = false)
    val completed: Boolean = false,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain(): Todo = Todo(
        id = id,
        title = title,
        description = description,
        completed = completed,
        createdAt = createdAt
    )

    companion object {
        fun fromDomain(todo: Todo): TodoEntity = TodoEntity(
            id = todo.id,
            title = todo.title,
            description = todo.description,
            completed = todo.completed,
            createdAt = todo.createdAt
        )
    }
}
