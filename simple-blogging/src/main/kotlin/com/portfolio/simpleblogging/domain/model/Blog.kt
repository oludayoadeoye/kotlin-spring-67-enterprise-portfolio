package com.portfolio.simpleblogging.domain.model

import java.time.LocalDateTime

data class Article(
    val id: Long? = null,
    val title: String,
    val body: String,
    val authorId: String,
    val category: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
