package com.portfolio.urlshortener.infrastructure.persistence

import com.portfolio.urlshortener.domain.model.ShortUrl
import com.portfolio.urlshortener.domain.repository.UrlRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "short_urls")
class ShortUrlEntity(
    @Id
    val id: String,
    @Column(columnDefinition = "TEXT")
    val originalUrl: String,
    @Column(unique = true)
    val shortCode: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = ShortUrl(id, originalUrl, shortCode, createdAt)
    companion object {
        fun fromDomain(u: ShortUrl) = ShortUrlEntity(u.id, u.originalUrl, u.shortCode, u.createdAt)
    }
}

interface SpringDataUrlRepository : JpaRepository<ShortUrlEntity, String> {
    fun findByShortCode(code: String): ShortUrlEntity?
}

@Repository
class JpaUrlRepositoryAdapter(private val repository: SpringDataUrlRepository) : UrlRepository {
    override suspend fun save(url: ShortUrl): ShortUrl = withContext(Dispatchers.IO) {
        repository.save(ShortUrlEntity.fromDomain(url)).toDomain()
    }
    override suspend fun findByCode(code: String): ShortUrl? = withContext(Dispatchers.IO) {
        repository.findByShortCode(code)?.toDomain()
    }
    override suspend fun findAll(): List<ShortUrl> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
