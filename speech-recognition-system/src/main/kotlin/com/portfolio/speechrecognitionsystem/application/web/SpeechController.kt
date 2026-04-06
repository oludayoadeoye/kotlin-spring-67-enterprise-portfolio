package com.portfolio.speechrecognitionsystem.application.web

import com.portfolio.speechrecognitionsystem.domain.service.SpeechService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/speech")
class SpeechController(private val service: SpeechService) {
    @PostMapping("/transcribe") fun transcribe(@RequestBody data: ByteArray) = service.transcribe(data)
}
