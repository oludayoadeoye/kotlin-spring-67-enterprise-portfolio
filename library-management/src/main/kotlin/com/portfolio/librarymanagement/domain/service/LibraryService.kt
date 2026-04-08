package com.portfolio.librarymanagement.domain.service

import com.portfolio.librarymanagement.domain.model.Book
import com.portfolio.librarymanagement.domain.repository.LibraryRepository
import org.springframework.stereotype.Service

@Service
class LibraryService(private val repository: LibraryRepository) {
    suspend fun getBooks(): List<Book> = repository.findAll()
    suspend fun getById(id: Long): Book? = repository.findById(id)
    suspend fun addBook(book: Book): Book = repository.save(book)
    suspend fun updateBook(id: Long, updated: Book): Book? {
        val existing = repository.findById(id) ?: return null
        return repository.save(updated.copy(id = existing.id))
    }
    suspend fun deleteBook(id: Long) = repository.deleteById(id)
}
