package com.portfolio.imagerecognition.domain.repository

import com.portfolio.imagerecognition.domain.model.RecognitionResult

interface ImageRecognitionRepository {
    suspend fun save(result: RecognitionResult): RecognitionResult
    suspend fun findAll(): List<RecognitionResult>
}
