package com.portfolio.notesapp.domain.service

import com.portfolio.notesapp.domain.model.Note
import com.portfolio.notesapp.domain.repository.NoteRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NoteService(private val repository: NoteRepository) {
    suspend fun getAllNotes(): List<Note> = repository.findAll()
    suspend fun getNoteById(id: Long): Note? = repository.findById(id)
    suspend fun createNote(note: Note): Note = repository.save(note)
    suspend fun updateNote(id: Long, updatedNote: Note): Note? {
        val existing = repository.findById(id) ?: return null
        return repository.save(updatedNote.copy(id = existing.id, updatedAt = LocalDateTime.now()))
    }
    suspend fun deleteNote(id: Long) = repository.deleteById(id)
}
