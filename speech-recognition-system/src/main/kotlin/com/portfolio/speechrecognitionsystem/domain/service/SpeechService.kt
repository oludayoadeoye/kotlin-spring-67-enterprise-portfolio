package com.portfolio.speechrecognitionsystem.domain.service

import com.portfolio.speechrecognitionsystem.domain.model.Transcription
import com.portfolio.speechrecognitionsystem.domain.repository.SpeechRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SpeechService(private val repository: SpeechRepository) {
    suspend fun transcribe(audioData: ByteArray): Transcription {
        val audioId = UUID.randomUUID().toString()
        val text = "Simulated high-performance transcription logic."
        val transcription = Transcription(id = UUID.randomUUID().toString(), audioId = audioId, text = text, confidence = 0.98)
        return repository.save(transcription)
    }

    suspend fun getHistory(): List<Transcription> = repository.findAll()
}
