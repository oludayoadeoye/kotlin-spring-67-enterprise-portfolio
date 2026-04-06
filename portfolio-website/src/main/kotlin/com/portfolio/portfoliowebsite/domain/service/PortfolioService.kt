package com.portfolio.portfoliowebsite.domain.service

import com.portfolio.portfoliowebsite.domain.model.Project
import com.portfolio.portfoliowebsite.domain.model.Skill
import org.springframework.stereotype.Service

@Service
class PortfolioService {
    private val projects = mutableListOf(
        Project(1, "Rust Portfolio", "67 backend projects in Rust", "https://github.com/...")
    )
    private val skills = listOf(Skill("Kotlin", "Expert"), Skill("Java", "Expert"))

    fun getProjects(): List<Project> = projects
    fun getSkills(): List<Skill> = skills
}
