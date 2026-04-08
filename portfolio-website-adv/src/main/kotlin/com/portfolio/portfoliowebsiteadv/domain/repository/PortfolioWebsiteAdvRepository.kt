package com.portfolio.portfoliowebsiteadv.domain.repository
import com.portfolio.portfoliowebsiteadv.domain.model.*
interface PortfolioWebsiteAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}