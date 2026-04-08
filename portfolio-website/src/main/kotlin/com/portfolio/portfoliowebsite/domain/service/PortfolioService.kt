package com.portfolio.portfoliowebsite.domain.service

import com.portfolio.portfoliowebsite.domain.model.Project
import com.portfolio.portfoliowebsite.domain.model.Skill
import com.portfolio.portfoliowebsite.domain.repository.PortfolioRepository
import org.springframework.stereotype.Service

@Service
class PortfolioService(private val repository: PortfolioRepository) {
    suspend fun getProjects(): List<Project> = repository.findAllProjects()
    suspend fun addProject(p: Project) = repository.saveProject(p)
    suspend fun getSkills(): List<Skill> = repository.findAllSkills()
    suspend fun addSkill(s: Skill) = repository.saveSkill(s)
}
