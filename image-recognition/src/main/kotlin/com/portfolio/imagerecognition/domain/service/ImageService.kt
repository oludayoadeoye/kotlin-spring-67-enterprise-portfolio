package com.portfolio.imagerecognition.domain.service

import com.portfolio.imagerecognition.domain.model.RecognitionResult
import org.springframework.stereotype.Service

@Service
class ImageService {
    fun recognize(imageUrl: String): List<RecognitionResult> {
        // Deep Logic Mock: Simulate recognition
        return listOf(
            RecognitionResult("Modern Building", 0.98),
            RecognitionResult("Sky", 0.85)
        )
    }
}
