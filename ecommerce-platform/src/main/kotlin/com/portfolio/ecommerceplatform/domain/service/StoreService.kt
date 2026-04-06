package com.portfolio.ecommerceplatform.domain.service

import com.portfolio.ecommerceplatform.domain.model.Product
import com.portfolio.ecommerceplatform.domain.model.Order
import org.springframework.stereotype.Service

@Service
class StoreService {
    private val products = mutableListOf(
        Product(1, "Laptop", 1200.0, 10),
        Product(2, "Mouse", 25.0, 50)
    )
    private val orders = mutableListOf<Order>()

    fun getProducts(): List<Product> = products
    fun placeOrder(items: List<Product>): Order {
        val total = items.sumOf { it.price }
        val order = Order(id = (orders.size + 1).toLong(), items = items, total = total)
        orders.add(order)
        return order
    }
}
