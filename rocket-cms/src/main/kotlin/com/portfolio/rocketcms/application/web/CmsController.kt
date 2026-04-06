package com.portfolio.rocketcms.application.web

import com.portfolio.rocketcms.domain.model.Page
import com.portfolio.rocketcms.domain.service.ContentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cms")
class CmsController(private val service: ContentService) {
    @GetMapping("/pages") fun pages() = service.getPages()
    @PostMapping("/pages") fun create(@RequestBody page: Page) = service.createPage(page)
}
