package com.portfolio.automatedtrading.infrastructure.persistence

import com.portfolio.automatedtrading.domain.model.TradeSignal
import com.portfolio.automatedtrading.domain.repository.TradingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "trade_signals")
class TradeSignalEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val symbol: String,
    val action: String,
    val confidence: Double,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = TradeSignal(id, symbol, action, confidence, timestamp)
    companion object {
        fun fromDomain(s: TradeSignal) = TradeSignalEntity(s.id, s.symbol, s.action, s.confidence, s.timestamp)
    }
}

interface SpringDataTradingRepository : JpaRepository<TradeSignalEntity, Long>

@Repository
class JpaTradingRepositoryAdapter(private val repository: SpringDataTradingRepository) : TradingRepository {
    override suspend fun save(signal: TradeSignal): TradeSignal = withContext(Dispatchers.IO) {
        repository.save(TradeSignalEntity.fromDomain(signal)).toDomain()
    }
    override suspend fun findAll(): List<TradeSignal> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
}
