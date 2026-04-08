package com.portfolio.ecommerceplatform.domain.service

import com.portfolio.ecommerceplatform.domain.model.Product
import com.portfolio.ecommerceplatform.domain.model.Order
import com.portfolio.ecommerceplatform.domain.repository.ProductRepository
import com.portfolio.ecommerceplatform.domain.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class StoreService(
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository
) {
    suspend fun getProducts(): List<Product> = productRepository.findAll()
    
    suspend fun placeOrder(items: List<Product>): Order {
        val total = items.sumOf { it.price }
        val order = Order(total = total)
        return orderRepository.save(order)
    }
}
