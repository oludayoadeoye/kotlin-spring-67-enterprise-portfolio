package com.portfolio.nlptool.application.web

import com.portfolio.nlptool.domain.service.NlpService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/nlp")
@Tag(name = "NLP", description = "Natural Language Processing endpoints")
class NlpController(private val service: NlpService) {
    @PostMapping("/analyze") suspend fun analyze(@RequestBody text: String) = service.analyze(text)
    @GetMapping("/history") suspend fun history() = service.getHistory()
}
