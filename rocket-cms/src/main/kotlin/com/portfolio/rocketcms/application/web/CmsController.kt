package com.portfolio.rocketcms.application.web

import com.portfolio.rocketcms.domain.model.Page
import com.portfolio.rocketcms.domain.service.ContentService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cms")
@Tag(name = "CMS", description = "Content management endpoints")
class CmsController(private val service: ContentService) {
    @GetMapping("/pages") suspend fun pages() = service.getPages()
    @GetMapping("/pages/{slug}") suspend fun page(@PathVariable slug: String) = service.getPage(slug)
    @PostMapping("/pages") suspend fun create(@RequestBody page: Page) = service.createPage(page)
}
