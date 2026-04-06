package com.portfolio.smartinventory.domain.service

import com.portfolio.smartinventory.domain.model.Item
import org.springframework.stereotype.Service

@Service
class InventoryService {
    private val items = mutableListOf<Item>()

    fun getItems(): List<Item> = items
    fun addItem(item: Item): Item {
        val newItem = item.copy(id = (items.size + 1).toLong())
        items.add(newItem)
        return newItem
    }
    fun updateStock(id: Long, qty: Int): Item? {
        val index = items.indexOfFirst { it.id == id }
        if (index == -1) return null
        val updated = items[index].copy(quantity = qty)
        items[index] = updated
        return updated
    }
}
