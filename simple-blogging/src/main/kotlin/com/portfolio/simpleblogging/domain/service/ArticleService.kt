package com.portfolio.simpleblogging.domain.service

import com.portfolio.simpleblogging.domain.model.Article
import org.springframework.stereotype.Service

@Service
class ArticleService {
    private val articles = mutableListOf<Article>()

    fun getAll(): List<Article> = articles
    fun publish(article: Article): Article {
        val newArticle = article.copy(id = (articles.size + 1).toLong())
        articles.add(newArticle)
        return newArticle
    }
}
