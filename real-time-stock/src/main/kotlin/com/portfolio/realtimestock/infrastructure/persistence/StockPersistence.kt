package com.portfolio.realtimestock.infrastructure.persistence

import com.portfolio.realtimestock.domain.model.AnalysisResult
import com.portfolio.realtimestock.domain.model.StockQuote
import com.portfolio.realtimestock.domain.repository.StockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity @Table(name = "stocks")
class StockEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val symbol: String,
    val currentPrice: Double,
    val lastUpdated: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = StockQuote(symbol, currentPrice, lastUpdated)
    companion object {
        fun fromDomain(q: StockQuote) = StockEntity(null, q.symbol, q.price, q.timestamp)
    }
}

@Entity @Table(name = "stock_analyses")
class AnalysisEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val symbol: String,
    val indicatorName: String,
    val value: Double,
    val recommendation: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = AnalysisResult(symbol, indicatorName, value, recommendation)
    companion object {
        fun fromDomain(r: AnalysisResult) = AnalysisEntity(null, r.symbol, r.indicator, r.value, r.recommendation)
    }
}

interface SpringDataStockRepo : JpaRepository<StockEntity, Long> {
    fun findBySymbolOrderByLastUpdatedDesc(symbol: String): List<StockEntity>
}
interface SpringDataAnalysisRepo : JpaRepository<AnalysisEntity, Long>

@Repository
class JpaStockRepositoryAdapter(
    private val stockRepo: SpringDataStockRepo,
    private val analysisRepo: SpringDataAnalysisRepo
) : StockRepository {
    override suspend fun saveQuote(quote: StockQuote): StockQuote = withContext(Dispatchers.IO) {
        stockRepo.save(StockEntity.fromDomain(quote)).toDomain()
    }
    override suspend fun saveAnalysis(analysis: AnalysisResult): AnalysisResult = withContext(Dispatchers.IO) {
        analysisRepo.save(AnalysisEntity.fromDomain(analysis)).toDomain()
    }
    override suspend fun findHistory(symbol: String): List<StockQuote> = withContext(Dispatchers.IO) {
        stockRepo.findBySymbolOrderByLastUpdatedDesc(symbol).map { it.toDomain() }
    }
}
