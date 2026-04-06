package com.portfolio.notesapp.infrastructure.persistence

import com.portfolio.notesapp.domain.model.Note
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "notes")
class NoteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    @Column(columnDefinition = "TEXT")
    val content: String,
    val tags: String?,
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = Note(id, title, content, tags, updatedAt)
    companion object {
        fun fromDomain(n: Note) = NoteEntity(n.id, n.title, n.content, n.tags, n.updatedAt)
    }
}
