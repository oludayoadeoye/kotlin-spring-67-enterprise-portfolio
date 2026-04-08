package com.portfolio.realtimelanguagetranslationapp.application.web

import com.portfolio.realtimelanguagetranslationapp.domain.service.AdvancedTranslationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/translate/v2")
class AdvancedTranslationController(private val service: AdvancedTranslationService) {
    @PostMapping("/session") fun start() = service.startSession()
}
