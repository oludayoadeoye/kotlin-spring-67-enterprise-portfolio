package com.portfolio.langlearningapp.application.web

import com.portfolio.langlearningapp.domain.service.LangService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/lang")
class LangController(private val service: LangService) {
    @GetMapping("/daily") fun daily() = service.getDailyVocab()
}
