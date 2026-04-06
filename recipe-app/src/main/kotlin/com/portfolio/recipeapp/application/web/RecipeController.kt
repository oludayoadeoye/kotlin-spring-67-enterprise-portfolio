package com.portfolio.recipeapp.application.web

import com.portfolio.recipeapp.domain.model.Recipe
import com.portfolio.recipeapp.domain.service.RecipeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/recipes")
class RecipeController(private val recipeService: RecipeService) {
    @GetMapping fun list() = recipeService.getAll()
    @PostMapping fun create(@RequestBody recipe: Recipe) = recipeService.add(recipe)
}
