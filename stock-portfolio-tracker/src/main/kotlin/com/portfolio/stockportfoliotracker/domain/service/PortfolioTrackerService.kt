package com.portfolio.stockportfoliotracker.domain.service

import com.portfolio.stockportfoliotracker.domain.model.PortfolioHolding
import org.springframework.stereotype.Service

@Service
class PortfolioTrackerService {
    fun getMyPortfolio(): List<PortfolioHolding> = listOf(
        PortfolioHolding("AAPL", 10, 150.0, 185.0),
        PortfolioHolding("TSLA", 5, 200.0, 175.0)
    )
}
