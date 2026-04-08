package com.portfolio.ecommerceplatformadv.domain.repository

import com.portfolio.ecommerceplatformadv.domain.model.CartItem

interface CartRepository {
    suspend fun findByUserId(userId: String): List<CartItem>
    suspend fun save(item: CartItem): CartItem
    suspend fun deleteByUserId(userId: String)
}
