package com.portfolio.flashcardapp.domain.service

import com.portfolio.flashcardapp.domain.model.Flashcard
import org.springframework.stereotype.Service

@Service
class FlashcardService {
    private val cards = mutableListOf<Flashcard>()

    fun getAll(): List<Flashcard> = cards
    fun add(card: Flashcard): Flashcard {
        val newCard = card.copy(id = (cards.size + 1).toLong())
        cards.add(newCard)
        return newCard
    }
}
