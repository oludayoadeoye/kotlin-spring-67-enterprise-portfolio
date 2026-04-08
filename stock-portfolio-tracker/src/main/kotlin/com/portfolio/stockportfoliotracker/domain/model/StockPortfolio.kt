package com.portfolio.stockportfoliotracker.domain.model

data class PortfolioHolding(
    val symbol: String,
    val shares: Int,
    val avgPrice: Double,
    val currentPrice: Double
) {
    val totalValue: Double get() = shares * currentPrice
    val profitLoss: Double get() = totalValue - (shares * avgPrice)
}
