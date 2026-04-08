package com.portfolio.recipeapp.domain.model

data class Recipe(
    val id: Long? = null,
    val title: String,
    val instructions: String,
    val ingredients: List<String> = emptyList()
)
