package com.portfolio.librarymanagement.application.web

import com.portfolio.librarymanagement.domain.model.Book
import com.portfolio.librarymanagement.domain.service.LibraryService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/library")
@Tag(name = "Library", description = "Library management endpoints")
class LibraryController(private val libraryService: LibraryService) {

    @GetMapping
    suspend fun list() = libraryService.getBooks()

    @GetMapping("/{id}")
    suspend fun get(@PathVariable id: Long): ResponseEntity<Book> =
        libraryService.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(@RequestBody book: Book) = libraryService.addBook(book)

    @PutMapping("/{id}")
    suspend fun update(@PathVariable id: Long, @RequestBody book: Book): ResponseEntity<Book> =
        libraryService.updateBook(id, book)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun delete(@PathVariable id: Long) = libraryService.deleteBook(id)
}
