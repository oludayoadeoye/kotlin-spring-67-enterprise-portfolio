package com.portfolio.librarymanagement.domain.repository

import com.portfolio.librarymanagement.domain.model.Book

interface LibraryRepository {
    suspend fun findAll(): List<Book>
    suspend fun findById(id: Long): Book?
    suspend fun save(book: Book): Book
    suspend fun deleteById(id: Long)
}
