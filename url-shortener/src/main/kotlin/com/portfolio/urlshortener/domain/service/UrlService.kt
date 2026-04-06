package com.portfolio.urlshortener.domain.service

import com.portfolio.urlshortener.domain.model.ShortUrl
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UrlService {
    private val urls = mutableMapOf<String, String>()

    fun shorten(originalUrl: String): ShortUrl {
        val code = UUID.randomUUID().toString().take(6)
        urls[code] = originalUrl
        return ShortUrl(code, originalUrl, "http://short.ly/$code")
    }

    fun resolve(code: String): String? = urls[code]
}
