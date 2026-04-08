package com.portfolio.personalblog.domain.repository

import com.portfolio.personalblog.domain.model.Post

interface PostRepository {
    suspend fun findAll(): List<Post>
    suspend fun findById(id: Long): Post?
    suspend fun save(post: Post): Post
    suspend fun deleteById(id: Long)
}
