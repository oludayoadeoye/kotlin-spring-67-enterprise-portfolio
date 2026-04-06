package com.portfolio.advancedecommerce.domain.model

data class CartItem(
    val productId: Long,
    val name: String,
    val price: Double,
    val quantity: Int
)

data class Cart(
    val userId: String,
    val items: MutableList<CartItem> = mutableListOf(),
    val total: Double = 0.0
)
