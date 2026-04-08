package com.portfolio.smartinventoryadv.infrastructure.persistence

import com.portfolio.smartinventoryadv.domain.model.StockLevel
import com.portfolio.smartinventoryadv.domain.repository.AdvancedInventoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "stock_levels")
class StockEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val sku: String,
    @Column(name = "current_stock")
    val current: Int,
    val minThreshold: Int,
    val needsRestock: Boolean,
    val lastUpdated: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() = StockLevel(id, sku, current, minThreshold, needsRestock, lastUpdated)
    companion object {
        fun fromDomain(s: StockLevel) = StockEntity(s.id, s.sku, s.current, s.minThreshold, s.needsRestock, s.lastUpdated)
    }
}

interface SpringDataStockRepository : JpaRepository<StockEntity, Long> {
    fun findBySku(sku: String): StockEntity?
}

@Repository
class JpaAdvancedInventoryRepositoryAdapter(private val repository: SpringDataStockRepository) : AdvancedInventoryRepository {
    override suspend fun findAll(): List<StockLevel> = withContext(Dispatchers.IO) {
        repository.findAll().map { it.toDomain() }
    }
    override suspend fun findBySku(sku: String): StockLevel? = withContext(Dispatchers.IO) {
        repository.findBySku(sku)?.toDomain()
    }
    override suspend fun save(stock: StockLevel): StockLevel = withContext(Dispatchers.IO) {
        repository.save(StockEntity.fromDomain(stock)).toDomain()
    }
}
