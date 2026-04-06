package com.portfolio.recipeapp.domain.service

import com.portfolio.recipeapp.domain.model.Recipe
import org.springframework.stereotype.Service

@Service
class RecipeService {
    private val recipes = mutableListOf<Recipe>()

    fun getAll(): List<Recipe> = recipes
    fun add(recipe: Recipe): Recipe {
        val newRecipe = recipe.copy(id = (recipes.size + 1).toLong())
        recipes.add(newRecipe)
        return newRecipe
    }
}
