package com.portfolio.flashcardapp.domain.repository

import com.portfolio.flashcardapp.domain.model.Flashcard

interface FlashcardRepository {
    suspend fun findAll(): List<Flashcard>
    suspend fun save(card: Flashcard): Flashcard
    suspend fun findById(id: Long): Flashcard?
    suspend fun deleteById(id: Long)
}
