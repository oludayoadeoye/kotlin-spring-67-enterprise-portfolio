package com.portfolio.smartinventory.domain.service

import com.portfolio.smartinventory.domain.model.Item
import com.portfolio.smartinventory.domain.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(private val repository: InventoryRepository) {
    suspend fun getItems(): List<Item> = repository.findAll()
    suspend fun addItem(item: Item): Item = repository.save(item)
    suspend fun updateStock(id: Long, qty: Int): Item? {
        val existing = repository.findById(id) ?: return null
        return repository.save(existing.copy(quantity = qty))
    }
    suspend fun delete(id: Long) = repository.deleteById(id)
}
