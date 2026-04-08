package com.portfolio.stockportfoliotracker.domain.repository

import com.portfolio.stockportfoliotracker.domain.model.PortfolioHolding

interface PortfolioTrackerRepository {
    suspend fun findAll(): List<PortfolioHolding>
    suspend fun save(holding: PortfolioHolding): PortfolioHolding
    suspend fun deleteById(id: Long)
}
