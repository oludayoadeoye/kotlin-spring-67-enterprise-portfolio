package com.portfolio.portfoliowebsiteadv.application.web

import com.portfolio.portfoliowebsiteadv.domain.service.AdvancedPortfolioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/portfolio/adv")
class AdvancedPortfolioController(private val service: AdvancedPortfolioService) {
    @GetMapping("/stats") fun stats() = service.getStats()
}
