package com.portfolio.personalblogadv.domain.service

import com.portfolio.personalblogadv.domain.model.AdvancedPost
import org.springframework.stereotype.Service

@Service
class AdvancedBlogService {
    private val posts = mutableListOf<AdvancedPost>()

    fun getPublished(): List<AdvancedPost> = posts.filter { !it.draft }
    fun create(post: AdvancedPost): AdvancedPost {
        val newPost = post.copy(id = (posts.size + 1).toLong())
        posts.add(newPost)
        return newPost
    }
}
