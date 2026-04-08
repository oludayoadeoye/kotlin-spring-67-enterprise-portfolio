package com.portfolio.simpleblogging.domain.repository

import com.portfolio.simpleblogging.domain.model.Article

interface ArticleRepository {
    suspend fun findAll(): List<Article>
    suspend fun findById(id: Long): Article?
    suspend fun save(article: Article): Article
    suspend fun deleteById(id: Long)
}
