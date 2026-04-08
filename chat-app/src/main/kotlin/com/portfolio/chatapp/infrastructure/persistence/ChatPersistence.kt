package com.portfolio.chatapp.infrastructure.persistence

import com.portfolio.chatapp.domain.model.Message
import com.portfolio.chatapp.domain.repository.ChatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "messages")
class MessageEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val sender: String,
    val content: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Message(id, sender, content, timestamp)
    companion object {
        fun fromDomain(m: Message) = MessageEntity(m.id, m.sender, m.content, m.timestamp)
    }
}

interface SpringDataChatRepository : JpaRepository<MessageEntity, Long>

@Repository
class JpaChatRepositoryAdapter(private val repository: SpringDataChatRepository) : ChatRepository {
    override suspend fun findAll(): List<Message> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(message: Message): Message = withContext(Dispatchers.IO) {
        repository.save(MessageEntity.fromDomain(message)).toDomain()
    }
}
