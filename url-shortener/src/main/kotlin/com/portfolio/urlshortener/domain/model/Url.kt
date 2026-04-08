package com.portfolio.urlshortener.domain.model

import java.time.LocalDateTime

data class ShortUrl(
    val id: String,
    val originalUrl: String,
    val shortCode: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
