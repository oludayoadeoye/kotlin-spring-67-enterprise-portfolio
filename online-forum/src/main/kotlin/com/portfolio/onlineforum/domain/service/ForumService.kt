package com.portfolio.onlineforum.domain.service

import com.portfolio.onlineforum.domain.model.Post
import com.portfolio.onlineforum.domain.model.Comment
import org.springframework.stereotype.Service

@Service
class ForumService {
    private val posts = mutableListOf<Post>()
    private val comments = mutableListOf<Comment>()

    fun getPosts(): List<Post> = posts
    fun createPost(post: Post): Post {
        val newPost = post.copy(id = (posts.size + 1).toLong())
        posts.add(newPost)
        return newPost
    }
    fun addComment(comment: Comment): Comment {
        val newComment = comment.copy(id = (comments.size + 1).toLong())
        comments.add(newComment)
        return newComment
    }
}
