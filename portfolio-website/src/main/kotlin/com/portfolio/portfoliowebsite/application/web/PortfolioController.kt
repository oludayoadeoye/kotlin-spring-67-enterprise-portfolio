package com.portfolio.portfoliowebsite.application.web

import com.portfolio.portfoliowebsite.domain.model.Project
import com.portfolio.portfoliowebsite.domain.model.Skill
import com.portfolio.portfoliowebsite.domain.service.PortfolioService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/portfolio")
@Tag(name = "Portfolio", description = "Portfolio management endpoints")
class PortfolioController(private val service: PortfolioService) {
    @GetMapping("/projects") suspend fun projects() = service.getProjects()
    @PostMapping("/projects") suspend fun addProject(@RequestBody p: Project) = service.addProject(p)
    @GetMapping("/skills") suspend fun skills() = service.getSkills()
    @PostMapping("/skills") suspend fun addSkill(@RequestBody s: Skill) = service.addSkill(s)
}
