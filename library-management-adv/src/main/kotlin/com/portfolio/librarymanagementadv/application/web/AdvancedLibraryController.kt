package com.portfolio.librarymanagementadv.application.web

import com.portfolio.librarymanagementadv.domain.service.AdvancedLibraryService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/library/adv")
@Tag(name = "Library Adv", description = "Advanced book loan management endpoints")
class AdvancedLibraryController(private val service: AdvancedLibraryService) {
    @GetMapping("/loans") suspend fun loans() = service.getActiveLoans()
    @PostMapping("/loan") suspend fun loan(@RequestParam bookId: String, @RequestParam memberId: String) = service.loanBook(bookId, memberId)
    @PostMapping("/return/{id}") suspend fun returnBook(@PathVariable id: Long): ResponseEntity<Any> =
        service.returnBook(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}
