package com.portfolio.stockportfoliotracker.domain.service

import com.portfolio.stockportfoliotracker.domain.model.PortfolioHolding
import com.portfolio.stockportfoliotracker.domain.repository.PortfolioTrackerRepository
import org.springframework.stereotype.Service

@Service
class PortfolioTrackerService(private val repository: PortfolioTrackerRepository) {
    suspend fun getMyPortfolio(): List<PortfolioHolding> = repository.findAll()
    suspend fun addHolding(holding: PortfolioHolding): PortfolioHolding = repository.save(holding)
    suspend fun deleteHolding(id: Long) = repository.deleteById(id)
}
