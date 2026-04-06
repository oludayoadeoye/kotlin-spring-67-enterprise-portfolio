package com.portfolio.flashcardapp.application.web

import com.portfolio.flashcardapp.domain.model.Flashcard
import com.portfolio.flashcardapp.domain.service.FlashcardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/flashcards")
class FlashcardController(private val service: FlashcardService) {
    @GetMapping fun list() = service.getAll()
    @PostMapping fun create(@RequestBody card: Flashcard) = service.add(card)
}
