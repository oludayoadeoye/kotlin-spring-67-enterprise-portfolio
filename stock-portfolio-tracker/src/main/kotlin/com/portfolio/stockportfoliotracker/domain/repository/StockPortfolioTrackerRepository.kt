package com.portfolio.stockportfoliotracker.domain.repository
import com.portfolio.stockportfoliotracker.domain.model.*
interface StockPortfolioTrackerRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}