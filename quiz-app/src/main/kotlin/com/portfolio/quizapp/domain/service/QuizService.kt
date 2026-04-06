package com.portfolio.quizapp.domain.service

import com.portfolio.quizapp.domain.model.Question
import com.portfolio.quizapp.domain.model.QuizResult
import org.springframework.stereotype.Service

@Service
class QuizService {
    private val questions = listOf(
        Question(1, "What is Kotlin?", listOf("Language", "Fruit", "Planet"), 0),
        Question(2, "Spring Boot is based on?", listOf("Java", "Python", "Ruby"), 0)
    )

    fun getQuestions(): List<Question> = questions

    fun calculateResult(answers: List<Int>): QuizResult {
        var score = 0
        answers.forEachIndexed { index, answer ->
            if (index < questions.size && answer == questions[index].correctAnswer) {
                score++
            }
        }
        return QuizResult(score, questions.size, (score.toDouble() / questions.size) * 100)
    }
}
