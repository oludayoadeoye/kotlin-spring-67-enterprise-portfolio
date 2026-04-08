package com.portfolio.smartinventoryadv.domain.model

import java.time.LocalDateTime

data class StockLevel(
    val id: Long? = null,
    val sku: String,
    val current: Int,
    val minThreshold: Int,
    val needsRestock: Boolean,
    val lastUpdated: LocalDateTime = LocalDateTime.now()
)
