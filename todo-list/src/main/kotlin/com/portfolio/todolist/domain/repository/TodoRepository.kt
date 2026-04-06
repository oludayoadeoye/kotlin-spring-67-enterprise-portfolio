package com.portfolio.todolist.domain.repository

import com.portfolio.todolist.domain.model.Todo

interface TodoRepository {
    fun findAll(): List<Todo>
    fun findById(id: Long): Todo?
    fun save(todo: Todo): Todo
    fun deleteById(id: Long)
}
