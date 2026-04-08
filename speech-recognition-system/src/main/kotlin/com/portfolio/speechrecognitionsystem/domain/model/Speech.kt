package com.portfolio.speechrecognitionsystem.domain.model

import java.time.LocalDateTime

data class Transcription(
    val id: String? = null,
    val audioId: String,
    val text: String,
    val confidence: Double,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
