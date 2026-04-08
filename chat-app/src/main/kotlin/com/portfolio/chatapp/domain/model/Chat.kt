package com.portfolio.chatapp.domain.model

import java.time.LocalDateTime

data class Message(
    val id: Long? = null,
    val sender: String,
    val content: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
