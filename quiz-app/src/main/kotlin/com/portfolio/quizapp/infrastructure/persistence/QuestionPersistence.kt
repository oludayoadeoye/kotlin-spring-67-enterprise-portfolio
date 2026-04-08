package com.portfolio.quizapp.infrastructure.persistence

import com.portfolio.quizapp.domain.model.Question
import com.portfolio.quizapp.domain.repository.QuestionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "questions")
class QuestionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val text: String,
    val options: String, // Comma separated for simplicity
    val correctAnswer: Int
) {
    fun toDomain() = Question(id, text, options.split(","), correctAnswer)
    companion object {
        fun fromDomain(q: Question) = QuestionEntity(q.id, q.text, q.options.joinToString(","), q.correctAnswer)
    }
}

interface SpringDataQuestionRepository : JpaRepository<QuestionEntity, Long>

@Repository
class JpaQuestionRepositoryAdapter(private val repository: SpringDataQuestionRepository) : QuestionRepository {
    override suspend fun findAll(): List<Question> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findById(id: Long): Question? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }
    override suspend fun save(question: Question): Question = withContext(Dispatchers.IO) {
        repository.save(QuestionEntity.fromDomain(question)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
