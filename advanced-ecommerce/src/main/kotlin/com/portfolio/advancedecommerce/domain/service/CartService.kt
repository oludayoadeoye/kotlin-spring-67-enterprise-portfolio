package com.portfolio.advancedecommerce.domain.service

import com.portfolio.advancedecommerce.domain.model.Cart
import com.portfolio.advancedecommerce.domain.model.CartItem
import org.springframework.stereotype.Service

@Service
class CartService {
    private val carts = mutableMapOf<String, Cart>()

    fun getCart(userId: String): Cart = carts.getOrPut(userId) { Cart(userId) }

    fun addItem(userId: String, item: CartItem): Cart {
        val cart = getCart(userId)
        cart.items.add(item)
        val updatedCart = cart.copy(total = cart.items.sumOf { it.price * it.quantity })
        carts[userId] = updatedCart
        return updatedCart
    }
}
