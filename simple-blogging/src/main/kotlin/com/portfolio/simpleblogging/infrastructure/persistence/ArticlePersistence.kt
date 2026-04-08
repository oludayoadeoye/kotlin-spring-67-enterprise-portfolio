package com.portfolio.simpleblogging.infrastructure.persistence

import com.portfolio.simpleblogging.domain.model.Article
import com.portfolio.simpleblogging.domain.repository.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "articles")
class ArticleEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    @Column(columnDefinition = "TEXT")
    val body: String,
    val authorId: String,
    val category: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Article(id, title, body, authorId, category, createdAt)
    companion object {
        fun fromDomain(a: Article) = ArticleEntity(a.id, a.title, a.body, a.authorId, a.category, a.createdAt)
    }
}

interface SpringDataArticleRepository : JpaRepository<ArticleEntity, Long>

@Repository
class JpaArticleRepositoryAdapter(private val repository: SpringDataArticleRepository) : ArticleRepository {
    override suspend fun findAll(): List<Article> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Article? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(article: Article): Article = withContext(Dispatchers.IO) {
        repository.save(ArticleEntity.fromDomain(article)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
