package com.portfolio.smartinventoryadv.domain.model

data class StockLevel(
    val sku: String,
    val current: Int,
    val minThreshold: Int,
    val needsRestock: Boolean
)
