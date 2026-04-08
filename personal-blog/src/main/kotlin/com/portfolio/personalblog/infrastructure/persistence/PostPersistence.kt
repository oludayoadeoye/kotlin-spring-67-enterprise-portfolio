package com.portfolio.personalblog.infrastructure.persistence

import com.portfolio.personalblog.domain.model.Post
import com.portfolio.personalblog.domain.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "posts")
class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    @Column(columnDefinition = "TEXT")
    val content: String,
    val author: String,
    val publishedAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Post(id, title, content, author, publishedAt)
    companion object {
        fun fromDomain(p: Post) = PostEntity(p.id, p.title, p.content, p.author, p.publishedAt)
    }
}

interface SpringDataPostRepository : JpaRepository<PostEntity, Long>

@Repository
class JpaPostRepositoryAdapter(private val repository: SpringDataPostRepository) : PostRepository {
    override suspend fun findAll(): List<Post> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Post? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(post: Post): Post = withContext(Dispatchers.IO) {
        repository.save(PostEntity.fromDomain(post)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
