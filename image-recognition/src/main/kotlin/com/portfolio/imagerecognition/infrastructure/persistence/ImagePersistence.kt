package com.portfolio.imagerecognition.infrastructure.persistence

import com.portfolio.imagerecognition.domain.model.RecognitionResult
import com.portfolio.imagerecognition.domain.repository.ImageRecognitionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "image_recognitions")
class RecognitionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(columnDefinition = "TEXT")
    val imageUrl: String,
    val labels: String, // Comma separated
    val confidence: Double
) {
    fun toDomain() = RecognitionResult(id, imageUrl, labels.split(","), confidence)
    companion object {
        fun fromDomain(r: RecognitionResult) = RecognitionEntity(r.id, r.imageUrl, r.labels.joinToString(","), r.confidence)
    }
}

interface SpringDataRecognitionRepository : JpaRepository<RecognitionEntity, Long>

@Repository
class JpaImageRecognitionRepositoryAdapter(private val repository: SpringDataRecognitionRepository) : ImageRecognitionRepository {
    override suspend fun save(result: RecognitionResult): RecognitionResult = withContext(Dispatchers.IO) {
        repository.save(RecognitionEntity.fromDomain(result)).toDomain()
    }
    override suspend fun findAll(): List<RecognitionResult> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
