package com.portfolio.notesapp.infrastructure.persistence

import com.portfolio.notesapp.domain.model.Note
import com.portfolio.notesapp.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface SpringDataNoteRepository : JpaRepository<NoteEntity, Long>

@Repository
class JpaNoteRepositoryAdapter(private val repository: SpringDataNoteRepository) : NoteRepository {
    override suspend fun findAll(): List<Note> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }

    override suspend fun findById(id: Long): Note? = withContext(Dispatchers.IO) {
        repository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override suspend fun save(note: Note): Note = withContext(Dispatchers.IO) {
        repository.save(NoteEntity.fromDomain(note)).toDomain()
    }

    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
