package com.portfolio.todolist.domain.service

import com.portfolio.todolist.domain.model.Todo
import com.portfolio.todolist.domain.repository.TodoRepository
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk

class TodoServiceTest : DescribeSpec({
    val repository = mockk<TodoRepository>()
    val service = TodoService(repository)

    describe("TodoService") {
        it("should return all todos") {
            val todos = listOf(Todo(id = 1, title = "Task 1", description = "Desc 1"))
            coEvery { repository.findAll() } returns todos

            val result = service.getAllTodos()

            result shouldBe todos
            coVerify(exactly = 1) { repository.findAll() }
        }

        it("should create a new todo") {
            val todo = Todo(title = "New Task", description = "New Desc")
            val savedTodo = todo.copy(id = 1)
            coEvery { repository.save(todo) } returns savedTodo

            val result = service.createTodo(todo)

            result shouldBe savedTodo
            coVerify(exactly = 1) { repository.save(todo) }
        }
    }
})
