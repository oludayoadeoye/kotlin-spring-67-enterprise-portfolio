package com.portfolio.urlshortener.application.web

import com.portfolio.urlshortener.domain.service.UrlService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/url")
class UrlController(private val service: UrlService) {
    @PostMapping("/shorten") fun shorten(@RequestBody url: String) = service.shorten(url)
    @GetMapping("/{code}") fun resolve(@PathVariable code: String) = service.resolve(code)
}
