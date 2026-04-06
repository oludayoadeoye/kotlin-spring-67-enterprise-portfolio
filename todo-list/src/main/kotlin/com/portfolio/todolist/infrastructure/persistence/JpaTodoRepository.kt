package com.portfolio.todolist.infrastructure.persistence

import com.portfolio.todolist.domain.model.Todo
import com.portfolio.todolist.domain.repository.TodoRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataTodoRepository : JpaRepository<TodoEntity, Long>

@Repository
class JpaTodoRepositoryAdapter(private val repository: SpringDataTodoRepository) : TodoRepository {
    override fun findAll(): List<Todo> = repository.findAll().map { it.toDomain() }

    override fun findById(id: Long): Todo? = repository.findById(id).map { it.toDomain() }.orElse(null)

    override fun save(todo: Todo): Todo {
        val entity = TodoEntity.fromDomain(todo)
        return repository.save(entity).toDomain()
    }

    override fun deleteById(id: Long) = repository.deleteById(id)
}
