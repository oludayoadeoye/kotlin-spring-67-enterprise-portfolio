package com.portfolio.langlearningapp.application.web

import com.portfolio.langlearningapp.domain.model.Vocabulary
import com.portfolio.langlearningapp.domain.service.LangService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/lang")
@Tag(name = "Lang Learning", description = "Vocabulary learning endpoints")
class LangController(private val service: LangService) {
    @GetMapping("/daily") suspend fun daily() = service.getDailyVocab()
    @GetMapping("/{id}") suspend fun get(@PathVariable id: Long): ResponseEntity<Vocabulary> =
        service.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    @PostMapping @ResponseStatus(HttpStatus.CREATED) suspend fun create(@RequestBody v: Vocabulary) = service.addVocab(v)
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) suspend fun delete(@PathVariable id: Long) = service.delete(id)
}
