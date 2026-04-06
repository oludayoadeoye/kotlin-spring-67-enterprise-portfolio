package com.portfolio.personalblogadv.application.web

import com.portfolio.personalblogadv.domain.model.AdvancedPost
import com.portfolio.personalblogadv.domain.service.AdvancedBlogService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blog/adv")
class AdvancedBlogController(private val service: AdvancedBlogService) {
    @GetMapping fun list() = service.getPublished()
    @PostMapping fun create(@RequestBody post: AdvancedPost) = service.create(post)
}
