package com.portfolio.ecommerceplatformadv.domain.service

import com.portfolio.ecommerceplatformadv.domain.model.Cart
import com.portfolio.ecommerceplatformadv.domain.model.CartItem
import com.portfolio.ecommerceplatformadv.domain.repository.CartRepository
import org.springframework.stereotype.Service

@Service
class AdvancedEcommerceService(private val repository: CartRepository) {
    suspend fun getCart(userId: String): Cart {
        val items = repository.findByUserId(userId)
        return Cart(userId, items, items.sumOf { it.price * it.quantity })
    }

    suspend fun addItem(item: CartItem): CartItem = repository.save(item)

    suspend fun clearCart(userId: String) = repository.deleteByUserId(userId)
}
