package com.portfolio.ecommerceplatformadv.domain.model

data class CartItem(
    val id: Long? = null,
    val userId: String,
    val productId: Long,
    val name: String,
    val price: Double,
    val quantity: Int
)

data class Cart(
    val userId: String,
    val items: List<CartItem>,
    val total: Double
)
