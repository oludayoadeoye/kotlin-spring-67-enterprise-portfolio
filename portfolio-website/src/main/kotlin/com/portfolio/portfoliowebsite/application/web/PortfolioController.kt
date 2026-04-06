package com.portfolio.portfoliowebsite.application.web

import com.portfolio.portfoliowebsite.domain.service.PortfolioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/portfolio")
class PortfolioController(private val service: PortfolioService) {
    @GetMapping("/projects") fun projects() = service.getProjects()
    @GetMapping("/skills") fun skills() = service.getSkills()
}
