package com.portfolio.imagerecognition.domain.service

import com.portfolio.imagerecognition.domain.model.RecognitionResult
import com.portfolio.imagerecognition.domain.repository.ImageRecognitionRepository
import org.springframework.stereotype.Service

@Service
class ImageService(private val repository: ImageRecognitionRepository) {
    suspend fun recognize(imageUrl: String): RecognitionResult {
        // Mock Deep Logic
        val result = RecognitionResult(
            imageUrl = imageUrl,
            labels = listOf("Modern Building", "Sky"),
            confidence = 0.98
        )
        return repository.save(result)
    }

    suspend fun getHistory(): List<RecognitionResult> = repository.findAll()
}
