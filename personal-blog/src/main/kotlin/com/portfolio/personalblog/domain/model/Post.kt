package com.portfolio.personalblog.domain.model

import java.time.LocalDateTime

data class Post(
    val id: Long? = null,
    val title: String,
    val content: String,
    val author: String,
    val publishedAt: LocalDateTime = LocalDateTime.now()
)
