package com.portfolio.librarymanagement.application.web

import com.portfolio.librarymanagement.domain.model.Book
import com.portfolio.librarymanagement.domain.service.LibraryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/library")
class LibraryController(private val libraryService: LibraryService) {
    @GetMapping fun list() = libraryService.getBooks()
    @PostMapping fun create(@RequestBody book: Book) = libraryService.addBook(book)
}
