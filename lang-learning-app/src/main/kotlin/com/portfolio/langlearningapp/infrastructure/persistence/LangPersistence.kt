package com.portfolio.langlearningapp.infrastructure.persistence

import com.portfolio.langlearningapp.domain.model.Vocabulary
import com.portfolio.langlearningapp.domain.repository.LangRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "vocabulary")
class VocabularyEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val word: String,
    val translation: String,
    val level: String
) {
    fun toDomain() = Vocabulary(id, word, translation, level)
    companion object {
        fun fromDomain(v: Vocabulary) = VocabularyEntity(v.id, v.word, v.translation, v.level)
    }
}

interface SpringDataLangRepository : JpaRepository<VocabularyEntity, Long>

@Repository
class JpaLangRepositoryAdapter(private val repository: SpringDataLangRepository) : LangRepository {
    override suspend fun findAll(): List<Vocabulary> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(vocab: Vocabulary): Vocabulary = withContext(Dispatchers.IO) {
        repository.save(VocabularyEntity.fromDomain(vocab)).toDomain()
    }
    override suspend fun findById(id: Long): Vocabulary? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
