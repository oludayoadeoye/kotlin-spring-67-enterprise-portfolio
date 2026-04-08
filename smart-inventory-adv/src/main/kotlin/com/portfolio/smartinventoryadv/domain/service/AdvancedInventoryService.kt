package com.portfolio.smartinventoryadv.domain.service

import com.portfolio.smartinventoryadv.domain.model.StockLevel
import com.portfolio.smartinventoryadv.domain.repository.AdvancedInventoryRepository
import org.springframework.stereotype.Service

@Service
class AdvancedInventoryService(private val repository: AdvancedInventoryRepository) {
    suspend fun getAlerts(): List<StockLevel> = repository.findAll().filter { it.needsRestock }
    
    suspend fun updateStock(sku: String, current: Int): StockLevel? {
        val existing = repository.findBySku(sku) ?: return null
        val needsRestock = current <= existing.minThreshold
        return repository.save(existing.copy(current = current, needsRestock = needsRestock))
    }

    suspend fun getAll(): List<StockLevel> = repository.findAll()
}
