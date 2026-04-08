package com.portfolio.recipeapp.domain.service

import com.portfolio.recipeapp.domain.model.Recipe
import com.portfolio.recipeapp.domain.repository.RecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeService(private val repository: RecipeRepository) {
    suspend fun getAll(): List<Recipe> = repository.findAll()
    suspend fun getById(id: Long): Recipe? = repository.findById(id)
    suspend fun create(recipe: Recipe): Recipe = repository.save(recipe)
    suspend fun update(id: Long, updated: Recipe): Recipe? {
        val existing = repository.findById(id) ?: return null
        return repository.save(updated.copy(id = existing.id))
    }
    suspend fun delete(id: Long) = repository.deleteById(id)
}
