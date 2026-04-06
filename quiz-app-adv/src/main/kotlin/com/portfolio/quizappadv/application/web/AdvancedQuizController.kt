package com.portfolio.quizappadv.application.web

import com.portfolio.quizappadv.domain.service.AdvancedQuizService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/quiz/adv")
class AdvancedQuizController(private val service: AdvancedQuizService) {
    @GetMapping("/generate") fun gen(@RequestParam cat: String) = service.generateQuiz(cat)
}
