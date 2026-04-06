package com.portfolio.quizapp.application.web

import com.portfolio.quizapp.domain.model.Question
import com.portfolio.quizapp.domain.model.QuizResult
import com.portfolio.quizapp.domain.service.QuizService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/quiz")
class QuizController(private val quizService: QuizService) {
    @GetMapping("/questions") fun questions(): List<Question> = quizService.getQuestions()
    @PostMapping("/submit") fun submit(@RequestBody answers: List<Int>): QuizResult = quizService.calculateResult(answers)
}
