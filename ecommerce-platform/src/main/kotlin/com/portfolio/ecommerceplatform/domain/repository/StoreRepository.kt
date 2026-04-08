package com.portfolio.ecommerceplatform.domain.repository

import com.portfolio.ecommerceplatform.domain.model.Product
import com.portfolio.ecommerceplatform.domain.model.Order

interface ProductRepository {
    suspend fun findAll(): List<Product>
    suspend fun findById(id: Long): Product?
    suspend fun save(product: Product): Product
}

interface OrderRepository {
    suspend fun save(order: Order): Order
    suspend fun findAll(): List<Order>
}
