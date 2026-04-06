package com.portfolio.notesapp.domain.model

import java.time.LocalDateTime

data class Note(
    val id: Long? = null,
    val title: String,
    val content: String,
    val tags: String? = null,
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
