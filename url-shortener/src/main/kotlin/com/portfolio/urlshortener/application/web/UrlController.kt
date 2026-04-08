package com.portfolio.urlshortener.application.web

import com.portfolio.urlshortener.domain.service.UrlService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/url")
@Tag(name = "URL Shortener", description = "URL optimization endpoints")
class UrlController(private val service: UrlService) {
    @PostMapping("/shorten") suspend fun shorten(@RequestBody url: String) = service.shorten(url)
    @GetMapping("/{code}") suspend fun resolve(@PathVariable code: String) = service.resolve(code)
    @GetMapping suspend fun list() = service.listAll()
}
