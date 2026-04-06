package com.portfolio.todolist.domain.service

import com.portfolio.todolist.domain.model.Todo
import com.portfolio.todolist.domain.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(private val todoRepository: TodoRepository) {
    fun getAllTodos(): List<Todo> = todoRepository.findAll()

    fun getTodoById(id: Long): Todo? = todoRepository.findById(id)

    fun createTodo(todo: Todo): Todo = todoRepository.save(todo)

    fun updateTodo(id: Long, updatedTodo: Todo): Todo? {
        val existingTodo = todoRepository.findById(id) ?: return null
        val todoToSave = updatedTodo.copy(id = existingTodo.id, createdAt = existingTodo.createdAt)
        return todoRepository.save(todoToSave)
    }

    fun deleteTodo(id: Long) = todoRepository.deleteById(id)
}
