package com.portfolio.urlshortener.domain.repository

import com.portfolio.urlshortener.domain.model.ShortUrl

interface UrlRepository {
    suspend fun save(url: ShortUrl): ShortUrl
    suspend fun findByCode(code: String): ShortUrl?
    suspend fun findAll(): List<ShortUrl>
}
