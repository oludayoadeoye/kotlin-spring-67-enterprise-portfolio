package com.portfolio.todolist.infrastructure.persistence

import com.portfolio.todolist.domain.model.Todo
import com.portfolio.todolist.domain.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataTodoRepository : JpaRepository<TodoEntity, Long>

@Repository
class JpaTodoRepositoryAdapter(private val repository: SpringDataTodoRepository) : TodoRepository {
    override suspend fun findAll(): List<Todo> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }

    override suspend fun findById(id: Long): Todo? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override suspend fun save(todo: Todo): Todo = withContext(Dispatchers.IO) {
        val entity = TodoEntity.fromDomain(todo)
        repository.save(entity).toDomain()
    }

    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
