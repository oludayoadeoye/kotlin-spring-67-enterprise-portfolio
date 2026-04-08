package com.portfolio.notesapp.domain.repository

import com.portfolio.notesapp.domain.model.Note

interface NoteRepository {
    suspend fun findAll(): List<Note>
    suspend fun findById(id: Long): Note?
    suspend fun save(note: Note): Note
    suspend fun deleteById(id: Long)
}
