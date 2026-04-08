package com.portfolio.notesapp.application.web

import com.portfolio.notesapp.domain.model.Note
import com.portfolio.notesapp.domain.service.NoteService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notes")
@Tag(name = "Notes", description = "Endpoints for personal notes management")
class NoteController(private val noteService: NoteService) {

    @GetMapping
    @Operation(summary = "List all notes")
    suspend fun getAll(): List<Note> = noteService.getAllNotes()

    @GetMapping("/{id}")
    @Operation(summary = "Get note by ID")
    suspend fun get(@PathVariable id: Long): ResponseEntity<Note> =
        noteService.getNoteById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new note")
    suspend fun create(@RequestBody note: Note): Note = noteService.createNote(note)

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing note")
    suspend fun update(@PathVariable id: Long, @RequestBody note: Note): ResponseEntity<Note> =
        noteService.updateNote(id, note)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a note")
    suspend fun delete(@PathVariable id: Long) = noteService.deleteNote(id)
}
