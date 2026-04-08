package com.portfolio.recipeapp.domain.repository

import com.portfolio.recipeapp.domain.model.Recipe

interface RecipeRepository {
    suspend fun findAll(): List<Recipe>
    suspend fun findById(id: Long): Recipe?
    suspend fun save(recipe: Recipe): Recipe
    suspend fun deleteById(id: Long)
}
