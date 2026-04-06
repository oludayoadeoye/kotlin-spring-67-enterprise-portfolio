package com.portfolio.personalblog.application.web

import com.portfolio.personalblog.domain.model.Post
import com.portfolio.personalblog.domain.service.BlogService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blog")
class BlogController(private val blogService: BlogService) {
    @GetMapping fun list() = blogService.getAll()
    @PostMapping fun create(@RequestBody post: Post) = blogService.create(post)
}
