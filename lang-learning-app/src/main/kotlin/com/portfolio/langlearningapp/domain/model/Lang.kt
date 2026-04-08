package com.portfolio.langlearningapp.domain.model

data class Vocabulary(
    val id: Long? = null,
    val word: String,
    val translation: String,
    val level: String
)
