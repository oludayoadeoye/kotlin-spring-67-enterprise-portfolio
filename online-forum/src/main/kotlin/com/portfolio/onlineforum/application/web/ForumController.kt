package com.portfolio.onlineforum.application.web

import com.portfolio.onlineforum.domain.model.Post
import com.portfolio.onlineforum.domain.model.Comment
import com.portfolio.onlineforum.domain.service.ForumService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/forum")
class ForumController(private val service: ForumService) {
    @GetMapping("/posts") fun posts() = service.getPosts()
    @PostMapping("/posts") fun createPost(@RequestBody post: Post) = service.createPost(post)
    @PostMapping("/comments") fun addComment(@RequestBody comment: Comment) = service.addComment(comment)
}
