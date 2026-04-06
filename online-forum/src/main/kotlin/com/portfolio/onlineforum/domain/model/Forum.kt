package com.portfolio.onlineforum.domain.model

import java.time.LocalDateTime

data class Post(
    val id: Long? = null,
    val author: String,
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)

data class Comment(
    val id: Long? = null,
    val postId: Long,
    val author: String,
    val text: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
