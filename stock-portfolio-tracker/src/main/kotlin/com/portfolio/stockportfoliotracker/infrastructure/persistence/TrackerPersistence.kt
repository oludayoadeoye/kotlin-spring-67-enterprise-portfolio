package com.portfolio.stockportfoliotracker.infrastructure.persistence

import com.portfolio.stockportfoliotracker.domain.model.PortfolioHolding
import com.portfolio.stockportfoliotracker.domain.repository.PortfolioTrackerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "stock_holdings")
class HoldingEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val symbol: String,
    val shares: Int,
    val avgPrice: Double,
    val currentPrice: Double
) {
    fun toDomain() = PortfolioHolding(id, symbol, shares, avgPrice, currentPrice)
    companion object {
        fun fromDomain(h: PortfolioHolding) = HoldingEntity(h.id, h.symbol, h.shares, h.avgPrice, h.currentPrice)
    }
}

interface SpringDataHoldingRepository : JpaRepository<HoldingEntity, Long>

@Repository
class JpaPortfolioTrackerRepositoryAdapter(private val repository: SpringDataHoldingRepository) : PortfolioTrackerRepository {
    override suspend fun findAll(): List<PortfolioHolding> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun save(holding: PortfolioHolding): PortfolioHolding = withContext(Dispatchers.IO) {
        repository.save(HoldingEntity.fromDomain(holding)).toDomain()
    }
    override suspend fun deleteById(id: Long) = withContext(Dispatchers.IO) {
        repository.deleteById(id)
    }
}
