package com.portfolio.librarymanagement.domain.service

import com.portfolio.librarymanagement.domain.model.Book
import org.springframework.stereotype.Service

@Service
class LibraryService {
    private val books = mutableListOf<Book>()

    fun getBooks(): List<Book> = books
    fun addBook(book: Book): Book {
        val newBook = book.copy(id = (books.size + 1).toLong())
        books.add(newBook)
        return newBook
    }
}
