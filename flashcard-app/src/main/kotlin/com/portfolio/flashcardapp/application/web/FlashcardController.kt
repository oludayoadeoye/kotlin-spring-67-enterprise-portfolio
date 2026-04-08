package com.portfolio.flashcardapp.application.web

import com.portfolio.flashcardapp.domain.model.Flashcard
import com.portfolio.flashcardapp.domain.service.FlashcardService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/flashcards")
@Tag(name = "Flashcards", description = "Learning flashcard endpoints")
class FlashcardController(private val service: FlashcardService) {
    @GetMapping suspend fun list() = service.getAll()
    @GetMapping("/{id}") suspend fun get(@PathVariable id: Long): ResponseEntity<Flashcard> =
        service.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    @PostMapping @ResponseStatus(HttpStatus.CREATED) suspend fun create(@RequestBody card: Flashcard) = service.addCard(card)
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) suspend fun delete(@PathVariable id: Long) = service.deleteCard(id)
}
