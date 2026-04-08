package com.portfolio.rocketcms.infrastructure.persistence

import com.portfolio.rocketcms.domain.model.Page
import com.portfolio.rocketcms.domain.repository.PageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "pages")
class PageEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    @Column(unique = true)
    val slug: String,
    @Column(columnDefinition = "TEXT")
    val content: String
) {
    fun toDomain() = Page(id, title, slug, content)
    companion object {
        fun fromDomain(p: Page) = PageEntity(p.id, p.title, p.slug, p.content)
    }
}

interface SpringDataPageRepository : JpaRepository<PageEntity, Long> {
    fun findBySlug(slug: String): PageEntity?
}

@Repository
class JpaPageRepositoryAdapter(private val repository: SpringDataPageRepository) : PageRepository {
    override suspend fun findAll(): List<Page> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findBySlug(slug: String): Page? = withContext(Dispatchers.IO) {
        repository.findBySlug(slug)?.toDomain()
    }
    override suspend fun save(page: Page): Page = withContext(Dispatchers.IO) {
        repository.save(PageEntity.fromDomain(page)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
