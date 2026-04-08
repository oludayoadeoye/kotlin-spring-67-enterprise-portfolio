package com.portfolio.smartinventory.domain.repository

import com.portfolio.smartinventory.domain.model.Item

interface InventoryRepository {
    suspend fun findAll(): List<Item>
    suspend fun findById(id: Long): Item?
    suspend fun save(item: Item): Item
    suspend fun deleteById(id: Long)
}
