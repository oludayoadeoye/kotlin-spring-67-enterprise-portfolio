package com.portfolio.smartinventory.domain.model

data class Item(
    val id: Long? = null,
    val name: String,
    val sku: String,
    val quantity: Int,
    val location: String
)
