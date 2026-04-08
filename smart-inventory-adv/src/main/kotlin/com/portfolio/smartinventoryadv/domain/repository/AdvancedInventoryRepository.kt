package com.portfolio.smartinventoryadv.domain.repository

import com.portfolio.smartinventoryadv.domain.model.StockLevel

interface AdvancedInventoryRepository {
    suspend fun findAll(): List<StockLevel>
    suspend fun findBySku(sku: String): StockLevel?
    suspend fun save(stock: StockLevel): StockLevel
}
