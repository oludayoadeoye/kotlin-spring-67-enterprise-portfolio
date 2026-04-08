package com.portfolio.imagerecognition.domain.model

data class RecognitionResult(
    val id: Long? = null,
    val imageUrl: String,
    val labels: List<String>,
    val confidence: Double
)
