package com.portfolio.quizappadv.domain.service

import com.portfolio.quizappadv.domain.model.AdvancedQuiz
import org.springframework.stereotype.Service

@Service
class AdvancedQuizService {
    fun generateQuiz(cat: String): AdvancedQuiz = AdvancedQuiz(cat, "Hard", 20)
}
