package com.portfolio.quizapp.application.web

import com.portfolio.quizapp.domain.model.Question
import com.portfolio.quizapp.domain.model.QuizResult
import com.portfolio.quizapp.domain.service.QuizService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/quiz")
@Tag(name = "Quiz", description = "Endpoints for quiz management")
class QuizController(private val quizService: QuizService) {

    @GetMapping("/questions")
    suspend fun questions(): List<Question> = quizService.getQuestions()

    @PostMapping("/questions")
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun add(@RequestBody q: Question) = quizService.addQuestion(q)

    @PostMapping("/submit")
    suspend fun submit(@RequestBody answers: List<Int>): QuizResult = quizService.calculateResult(answers)
}
