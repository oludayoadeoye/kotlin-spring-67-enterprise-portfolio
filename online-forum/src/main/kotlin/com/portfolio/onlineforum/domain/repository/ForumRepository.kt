package com.portfolio.onlineforum.domain.repository

import com.portfolio.onlineforum.domain.model.Post
import com.portfolio.onlineforum.domain.model.Comment

interface ForumRepository {
    suspend fun findAllPosts(): List<Post>
    suspend fun savePost(post: Post): Post
    suspend fun findPostById(id: Long): Post?
    suspend fun findCommentsByPostId(postId: Long): List<Comment>
    suspend fun saveComment(comment: Comment): Comment
}
