package com.portfolio.flashcardapp.domain.model

data class Flashcard(
    val id: Long? = null,
    val question: String,
    val answer: String,
    val category: String
)
