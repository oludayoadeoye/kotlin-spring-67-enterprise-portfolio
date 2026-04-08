package com.portfolio.speechrecognitionsystem.infrastructure.persistence

import com.portfolio.speechrecognitionsystem.domain.model.Transcription
import com.portfolio.speechrecognitionsystem.domain.repository.SpeechRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "transcriptions")
class TranscriptionEntity(
    @Id
    val id: String,
    val audioId: String,
    @Column(columnDefinition = "TEXT")
    val text: String,
    val confidence: Double,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Transcription(id, audioId, text, confidence, createdAt)
    companion object {
        fun fromDomain(t: Transcription) = TranscriptionEntity(t.id!!, t.audioId, t.text, t.confidence, t.createdAt)
    }
}

interface SpringDataSpeechRepository : JpaRepository<TranscriptionEntity, String>

@Repository
class JpaSpeechRepositoryAdapter(private val repository: SpringDataSpeechRepository) : SpeechRepository {
    override suspend fun save(transcription: Transcription): Transcription = withContext(Dispatchers.IO) {
        repository.save(TranscriptionEntity.fromDomain(transcription)).toDomain()
    }
    override suspend fun findAll(): List<Transcription> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
