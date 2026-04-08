package com.portfolio.flashcardapp.infrastructure.persistence

import com.portfolio.flashcardapp.domain.model.Flashcard
import com.portfolio.flashcardapp.domain.repository.FlashcardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "flashcards")
class FlashcardEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(columnDefinition = "TEXT")
    val question: String,
    @Column(columnDefinition = "TEXT")
    val answer: String,
    val category: String
) {
    fun toDomain() = Flashcard(id, question, answer, category)
    companion object {
        fun fromDomain(f: Flashcard) = FlashcardEntity(f.id, f.question, f.answer, f.category)
    }
}

interface SpringDataFlashcardRepository : JpaRepository<FlashcardEntity, Long>

@Repository
class JpaFlashcardRepositoryAdapter(private val repository: SpringDataFlashcardRepository) : FlashcardRepository {
    override suspend fun findAll(): List<Flashcard> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(card: Flashcard): Flashcard = withContext(Dispatchers.IO) {
        repository.save(FlashcardEntity.fromDomain(card)).toDomain()
    }
    override suspend fun findById(id: Long): Flashcard? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
