package com.portfolio.todolist.domain.repository

import com.portfolio.todolist.domain.model.Todo

interface TodoRepository {
    suspend fun findAll(): List<Todo>
    suspend fun findById(id: Long): Todo?
    suspend fun save(todo: Todo): Todo
    suspend fun deleteById(id: Long)
}
