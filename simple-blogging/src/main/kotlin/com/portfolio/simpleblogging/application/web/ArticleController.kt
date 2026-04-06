package com.portfolio.simpleblogging.application.web

import com.portfolio.simpleblogging.domain.model.Article
import com.portfolio.simpleblogging.domain.service.ArticleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blog/articles")
class ArticleController(private val articleService: ArticleService) {
    @GetMapping fun list() = articleService.getAll()
    @PostMapping fun publish(@RequestBody article: Article) = articleService.publish(article)
}
