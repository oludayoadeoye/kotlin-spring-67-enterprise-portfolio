package com.portfolio.flashcardapp.domain.service

import com.portfolio.flashcardapp.domain.model.Flashcard
import com.portfolio.flashcardapp.domain.repository.FlashcardRepository
import org.springframework.stereotype.Service

@Service
class FlashcardService(private val repository: FlashcardRepository) {
    suspend fun getAll(): List<Flashcard> = repository.findAll()
    suspend fun getById(id: Long): Flashcard? = repository.findById(id)
    suspend fun addCard(card: Flashcard): Flashcard = repository.save(card)
    suspend fun deleteCard(id: Long) = repository.deleteById(id)
}
