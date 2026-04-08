package com.portfolio.onlineforum.domain.service

import com.portfolio.onlineforum.domain.model.Post
import com.portfolio.onlineforum.domain.model.Comment
import com.portfolio.onlineforum.domain.repository.ForumRepository
import org.springframework.stereotype.Service

@Service
class ForumService(private val repository: ForumRepository) {
    suspend fun getPosts(): List<Post> = repository.findAllPosts()
    suspend fun createPost(post: Post): Post = repository.savePost(post)
    suspend fun addComment(comment: Comment): Comment = repository.saveComment(comment)
    suspend fun getComments(postId: Long): List<Comment> = repository.findCommentsByPostId(postId)
}
