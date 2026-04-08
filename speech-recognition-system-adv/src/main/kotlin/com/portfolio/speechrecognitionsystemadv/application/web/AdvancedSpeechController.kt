package com.portfolio.speechrecognitionsystemadv.application.web

import com.portfolio.speechrecognitionsystemadv.domain.service.AdvancedSpeechService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/speech/adv")
class AdvancedSpeechController(private val service: AdvancedSpeechService) {
    @PostMapping("/auth") fun auth(@RequestParam id: String) = service.authenticate(id)
}
