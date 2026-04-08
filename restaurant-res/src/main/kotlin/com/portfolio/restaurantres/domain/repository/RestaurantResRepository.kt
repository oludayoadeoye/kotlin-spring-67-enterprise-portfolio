package com.portfolio.restaurantres.domain.repository
import com.portfolio.restaurantres.domain.model.*
interface RestaurantResRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}