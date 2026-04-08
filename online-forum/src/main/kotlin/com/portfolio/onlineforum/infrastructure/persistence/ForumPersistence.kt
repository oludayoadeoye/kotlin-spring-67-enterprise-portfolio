package com.portfolio.onlineforum.infrastructure.persistence

import com.portfolio.onlineforum.domain.model.Post
import com.portfolio.onlineforum.domain.model.Comment
import com.portfolio.onlineforum.domain.repository.ForumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "forum_posts")
class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val author: String,
    @Column(columnDefinition = "TEXT")
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Post(id, author, content, createdAt)
    companion object {
        fun fromDomain(p: Post) = PostEntity(p.id, p.author, p.content, p.createdAt)
    }
}

@Entity
@Table(name = "forum_comments")
class CommentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val postId: Long,
    val author: String,
    @Column(columnDefinition = "TEXT")
    val text: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Comment(id, postId, author, text, createdAt)
    companion object {
        fun fromDomain(c: Comment) = CommentEntity(c.id, c.postId, c.author, c.text, c.createdAt)
    }
}

interface SpringDataPostRepository : JpaRepository<PostEntity, Long>
interface SpringDataCommentRepository : JpaRepository<CommentEntity, Long> {
    fun findByPostId(postId: Long): List<CommentEntity>
}

@Repository
class JpaForumRepositoryAdapter(
    private val postRepo: SpringDataPostRepository,
    private val commentRepo: SpringDataCommentRepository
) : ForumRepository {
    override suspend fun findAllPosts(): List<Post> = withContext(Dispatchers.IO) {
        postRepo.findAll().map { it.toDomain() }
    }
    override suspend fun savePost(post: Post): Post = withContext(Dispatchers.IO) {
        postRepo.save(PostEntity.fromDomain(post)).toDomain()
    }
    override suspend fun findPostById(id: Long): Post? = withContext(Dispatchers.IO) {
        postRepo.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun findCommentsByPostId(postId: Long): List<Comment> = withContext(Dispatchers.IO) {
        commentRepo.findByPostId(postId).map { it.toDomain() }
    }
    override suspend fun saveComment(comment: Comment): Comment = withContext(Dispatchers.IO) {
        commentRepo.save(CommentEntity.fromDomain(comment)).toDomain()
    }
}
