package com.portfolio.urlshortener.domain.model

data class ShortUrl(
    val id: String,
    val originalUrl: String,
    val shortCode: String
)
