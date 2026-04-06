package com.portfolio.quizapp.domain.model

data class Question(
    val id: Long? = null,
    val text: String,
    val options: List<String>,
    val correctAnswer: Int
)

data class QuizResult(
    val score: Int,
    val total: Int,
    val percentage: Double
)
