package com.portfolio.personalblog.domain.service

import com.portfolio.personalblog.domain.model.Post
import com.portfolio.personalblog.domain.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class BlogService(private val repository: PostRepository) {
    suspend fun getAll(): List<Post> = repository.findAll()
    suspend fun getById(id: Long): Post? = repository.findById(id)
    suspend fun create(post: Post): Post = repository.save(post)
    suspend fun update(id: Long, updatedPost: Post): Post? {
        val existing = repository.findById(id) ?: return null
        return repository.save(updatedPost.copy(id = existing.id, publishedAt = existing.publishedAt))
    }
    suspend fun delete(id: Long) = repository.deleteById(id)
}
