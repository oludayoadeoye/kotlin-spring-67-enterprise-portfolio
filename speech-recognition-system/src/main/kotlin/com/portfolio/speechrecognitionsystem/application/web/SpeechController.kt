package com.portfolio.speechrecognitionsystem.application.web

import com.portfolio.speechrecognitionsystem.domain.service.SpeechService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/speech")
@Tag(name = "Speech", description = "Speech recognition and transcription endpoints")
class SpeechController(private val service: SpeechService) {
    @PostMapping("/transcribe") suspend fun transcribe(@RequestBody data: ByteArray) = service.transcribe(data)
    @GetMapping("/history") suspend fun history() = service.getHistory()
}
