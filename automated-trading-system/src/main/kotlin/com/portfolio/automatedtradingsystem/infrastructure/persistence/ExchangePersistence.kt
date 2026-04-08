package com.portfolio.automatedtradingsystem.infrastructure.persistence

import com.portfolio.automatedtradingsystem.domain.model.OrderBookEntry
import com.portfolio.automatedtradingsystem.domain.repository.ExchangeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*

@Entity
@Table(name = "order_book_entries")
class OrderBookEntryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val symbol: String,
    val side: String,
    val price: Double,
    val quantity: Double
) {
    fun toDomain() = OrderBookEntry(id, symbol, side, price, quantity)
    companion object {
        fun fromDomain(e: OrderBookEntry) = OrderBookEntryEntity(e.id, e.symbol, e.side, e.price, e.quantity)
    }
}

interface SpringDataExchangeRepository : JpaRepository<OrderBookEntryEntity, Long> {
    fun findAllBySymbol(symbol: String): List<OrderBookEntryEntity>
}

@Repository
class JpaExchangeRepositoryAdapter(private val repository: SpringDataExchangeRepository) : ExchangeRepository {
    override suspend fun findAllBySymbol(symbol: String): List<OrderBookEntry> = withContext(Dispatchers.IO) {
        repository.findAllBySymbol(symbol).map { it.toDomain() }
    }
    override suspend fun save(entry: OrderBookEntry): OrderBookEntry = withContext(Dispatchers.IO) {
        repository.save(OrderBookEntryEntity.fromDomain(entry)).toDomain()
    }
}
