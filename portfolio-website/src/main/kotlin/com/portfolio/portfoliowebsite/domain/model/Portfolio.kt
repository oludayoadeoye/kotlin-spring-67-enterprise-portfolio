package com.portfolio.portfoliowebsite.domain.model

data class Project(
    val id: Long? = null,
    val title: String,
    val description: String,
    val url: String? = null
)

data class Skill(
    val id: Long? = null,
    val name: String,
    val level: String
)
