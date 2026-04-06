package com.portfolio.nlptool.application.web

import com.portfolio.nlptool.domain.service.NlpService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/nlp")
class NlpController(private val service: NlpService) {
    @PostMapping("/analyze") fun analyze(@RequestBody text: String) = service.analyze(text)
}
