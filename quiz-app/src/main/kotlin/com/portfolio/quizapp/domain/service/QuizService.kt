package com.portfolio.quizapp.domain.service

import com.portfolio.quizapp.domain.model.Question
import com.portfolio.quizapp.domain.model.QuizResult
import com.portfolio.quizapp.domain.repository.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuizService(private val repository: QuestionRepository) {
    
    suspend fun getQuestions(): List<Question> = repository.findAll()

    suspend fun addQuestion(q: Question): Question = repository.save(q)

    suspend fun calculateResult(answers: List<Int>): QuizResult {
        val questions = repository.findAll()
        var score = 0
        answers.forEachIndexed { index, answer ->
            if (index < questions.size && answer == questions[index].correctAnswer) {
                score++
            }
        }
        return QuizResult(score, questions.size, (score.toDouble() / questions.size) * 100)
    }
}
