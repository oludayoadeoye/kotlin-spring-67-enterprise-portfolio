package com.portfolio.smartinventoryadv.domain.service

import com.portfolio.smartinventoryadv.domain.model.StockLevel
import org.springframework.stereotype.Service

@Service
class AdvancedInventoryService {
    fun getAlerts(): List<StockLevel> = listOf(
        StockLevel("SKU-99", 5, 10, true),
        StockLevel("SKU-101", 50, 20, false)
    )
}
