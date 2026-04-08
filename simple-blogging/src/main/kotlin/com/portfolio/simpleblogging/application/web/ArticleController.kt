package com.portfolio.simpleblogging.application.web

import com.portfolio.simpleblogging.domain.model.Article
import com.portfolio.simpleblogging.domain.service.ArticleService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blog/articles")
@Tag(name = "Blogging", description = "Endpoints for article management")
class ArticleController(private val articleService: ArticleService) {

    @GetMapping
    suspend fun list() = articleService.getAll()

    @GetMapping("/{id}")
    suspend fun get(@PathVariable id: Long): ResponseEntity<Article> =
        articleService.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun publish(@RequestBody article: Article) = articleService.publish(article)

    @PutMapping("/{id}")
    suspend fun update(@PathVariable id: Long, @RequestBody article: Article): ResponseEntity<Article> =
        articleService.update(id, article)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun delete(@PathVariable id: Long) = articleService.delete(id)
}
