package com.portfolio.notesapp.infrastructure.persistence

import com.portfolio.notesapp.domain.model.Note
import com.portfolio.notesapp.domain.repository.NoteRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataNoteRepository : JpaRepository<NoteEntity, Long>

@Repository
class JpaNoteRepositoryAdapter(private val repository: SpringDataNoteRepository) : NoteRepository {
    override fun findAll(): List<Note> = repository.findAll().map { it.toDomain() }
    override fun findById(id: Long): Note? = repository.findById(id).map { it.toDomain() }.orElse(null)
    override fun save(note: Note): Note = repository.save(NoteEntity.fromDomain(note)).toDomain()
    override fun deleteById(id: Long) = repository.deleteById(id)
}
