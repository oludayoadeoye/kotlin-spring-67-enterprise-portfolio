package com.portfolio.personalblog.application.web

import com.portfolio.personalblog.domain.model.Post
import com.portfolio.personalblog.domain.service.BlogService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blog")
@Tag(name = "Blog", description = "Endpoints for blog post management")
class BlogController(private val blogService: BlogService) {

    @GetMapping
    suspend fun list() = blogService.getAll()

    @GetMapping("/{id}")
    suspend fun get(@PathVariable id: Long): ResponseEntity<Post> =
        blogService.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(@RequestBody post: Post) = blogService.create(post)

    @PutMapping("/{id}")
    suspend fun update(@PathVariable id: Long, @RequestBody post: Post): ResponseEntity<Post> =
        blogService.update(id, post)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun delete(@PathVariable id: Long) = blogService.delete(id)
}
