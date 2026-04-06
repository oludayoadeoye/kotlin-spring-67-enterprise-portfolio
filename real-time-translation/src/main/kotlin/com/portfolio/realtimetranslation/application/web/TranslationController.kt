package com.portfolio.realtimetranslation.application.web

import com.portfolio.realtimetranslation.domain.service.TranslationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/translate")
class TranslationController(private val service: TranslationService) {
    @PostMapping
    fun translate(@RequestParam text: String, @RequestParam from: String, @RequestParam to: String) =
        service.translate(text, from, to)
}
