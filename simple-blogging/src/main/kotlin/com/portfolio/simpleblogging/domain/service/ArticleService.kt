package com.portfolio.simpleblogging.domain.service

import com.portfolio.simpleblogging.domain.model.Article
import com.portfolio.simpleblogging.domain.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(private val repository: ArticleRepository) {
    suspend fun getAll(): List<Article> = repository.findAll()
    suspend fun getById(id: Long): Article? = repository.findById(id)
    suspend fun publish(article: Article): Article = repository.save(article)
    suspend fun update(id: Long, updated: Article): Article? {
        val existing = repository.findById(id) ?: return null
        return repository.save(updated.copy(id = existing.id, createdAt = existing.createdAt))
    }
    suspend fun delete(id: Long) = repository.deleteById(id)
}
