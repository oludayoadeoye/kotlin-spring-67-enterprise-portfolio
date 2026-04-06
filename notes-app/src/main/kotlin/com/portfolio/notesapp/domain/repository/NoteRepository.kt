package com.portfolio.notesapp.domain.repository

import com.portfolio.notesapp.domain.model.Note

interface NoteRepository {
    fun findAll(): List<Note>
    fun findById(id: Long): Note?
    fun save(note: Note): Note
    fun deleteById(id: Long)
}
