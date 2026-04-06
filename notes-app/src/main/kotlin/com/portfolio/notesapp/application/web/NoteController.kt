package com.portfolio.notesapp.application.web

import com.portfolio.notesapp.domain.model.Note
import com.portfolio.notesapp.domain.service.NoteService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notes")
@Tag(name = "Notes", description = "Endpoints for personal notes")
class NoteController(private val noteService: NoteService) {

    @GetMapping
    @Operation(summary = "List all notes")
    fun getAll(): List<Note> = noteService.getAllNotes()

    @PostMapping
    @Operation(summary = "Create a note")
    fun create(@RequestBody note: Note): Note = noteService.createNote(note)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Note? = noteService.getNoteById(id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = noteService.deleteNote(id)
}
