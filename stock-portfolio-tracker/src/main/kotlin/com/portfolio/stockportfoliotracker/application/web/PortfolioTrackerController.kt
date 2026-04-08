package com.portfolio.stockportfoliotracker.application.web

import com.portfolio.stockportfoliotracker.domain.service.PortfolioTrackerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/portfolio/tracker")
class PortfolioTrackerController(private val service: PortfolioTrackerService) {
    @GetMapping fun myPortfolio() = service.getMyPortfolio()
}
