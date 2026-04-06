package com.portfolio.speechrecognitionsystem.domain.model

data class Transcription(
    val audioId: String,
    val text: String,
    val confidence: Double
)
