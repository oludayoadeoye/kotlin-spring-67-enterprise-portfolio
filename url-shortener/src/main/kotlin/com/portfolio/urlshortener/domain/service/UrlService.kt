package com.portfolio.urlshortener.domain.service

import com.portfolio.urlshortener.domain.model.ShortUrl
import com.portfolio.urlshortener.domain.repository.UrlRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UrlService(private val repository: UrlRepository) {
    suspend fun shorten(originalUrl: String): ShortUrl {
        val id = UUID.randomUUID().toString()
        val code = id.take(6)
        val shortUrl = ShortUrl(id, originalUrl, code)
        return repository.save(shortUrl)
    }

    suspend fun resolve(code: String): String? = repository.findByCode(code)?.originalUrl
    
    suspend fun listAll(): List<ShortUrl> = repository.findAll()
}
