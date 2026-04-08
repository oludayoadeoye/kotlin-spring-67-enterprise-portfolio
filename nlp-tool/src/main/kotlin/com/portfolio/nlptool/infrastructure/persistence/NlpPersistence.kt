package com.portfolio.nlptool.infrastructure.persistence

import com.portfolio.nlptool.domain.model.Analysis
import com.portfolio.nlptool.domain.repository.NlpRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "nlp_analyses")
class AnalysisEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(columnDefinition = "TEXT")
    val text: String,
    val sentiment: String,
    val keywords: String,
    val language: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Analysis(id, text, sentiment, keywords.split(","), language, createdAt)
    companion object {
        fun fromDomain(a: Analysis) = AnalysisEntity(a.id, a.text, a.sentiment, a.keywords.joinToString(","), a.language, a.createdAt)
    }
}

interface SpringDataNlpRepository : JpaRepository<AnalysisEntity, Long>

@Repository
class JpaNlpRepositoryAdapter(private val repository: SpringDataNlpRepository) : NlpRepository {
    override suspend fun save(analysis: Analysis): Analysis = withContext(Dispatchers.IO) {
        repository.save(AnalysisEntity.fromDomain(analysis)).toDomain()
    }
    override suspend fun findAll(): List<Analysis> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
