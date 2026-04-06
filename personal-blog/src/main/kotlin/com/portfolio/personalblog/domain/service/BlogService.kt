package com.portfolio.personalblog.domain.service

import com.portfolio.personalblog.domain.model.Post
import org.springframework.stereotype.Service

@Service
class BlogService {
    private val posts = mutableListOf<Post>()

    fun getAll(): List<Post> = posts
    fun create(post: Post): Post {
        val newPost = post.copy(id = (posts.size + 1).toLong())
        posts.add(newPost)
        return newPost
    }
}
