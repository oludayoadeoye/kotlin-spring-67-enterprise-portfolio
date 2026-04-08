package com.portfolio.portfoliowebsite.domain.repository

import com.portfolio.portfoliowebsite.domain.model.Project
import com.portfolio.portfoliowebsite.domain.model.Skill

interface PortfolioRepository {
    suspend fun findAllProjects(): List<Project>
    suspend fun saveProject(project: Project): Project
    suspend fun findAllSkills(): List<Skill>
    suspend fun saveSkill(skill: Skill): Skill
}
