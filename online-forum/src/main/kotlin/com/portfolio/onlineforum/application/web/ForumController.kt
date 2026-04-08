package com.portfolio.onlineforum.application.web

import com.portfolio.onlineforum.domain.model.Post
import com.portfolio.onlineforum.domain.model.Comment
import com.portfolio.onlineforum.domain.service.ForumService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/forum")
@Tag(name = "Forum", description = "Forum community endpoints")
class ForumController(private val service: ForumService) {
    @GetMapping("/posts") suspend fun posts() = service.getPosts()
    @PostMapping("/posts") suspend fun createPost(@RequestBody post: Post) = service.createPost(post)
    @GetMapping("/posts/{id}/comments") suspend fun comments(@PathVariable id: Long) = service.getComments(id)
    @PostMapping("/comments") suspend fun addComment(@RequestBody comment: Comment) = service.addComment(comment)
}
