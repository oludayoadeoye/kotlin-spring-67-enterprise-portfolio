package com.portfolio.recipeapp.application.web

import com.portfolio.recipeapp.domain.model.Recipe
import com.portfolio.recipeapp.domain.service.RecipeService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/recipes")
@Tag(name = "Recipes", description = "Endpoints for recipe management")
class RecipeController(private val recipeService: RecipeService) {

    @GetMapping
    suspend fun list() = recipeService.getAll()

    @GetMapping("/{id}")
    suspend fun get(@PathVariable id: Long): ResponseEntity<Recipe> =
        recipeService.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(@RequestBody recipe: Recipe) = recipeService.create(recipe)

    @PutMapping("/{id}")
    suspend fun update(@PathVariable id: Long, @RequestBody recipe: Recipe): ResponseEntity<Recipe> =
        recipeService.update(id, recipe)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun delete(@PathVariable id: Long) = recipeService.delete(id)
}
