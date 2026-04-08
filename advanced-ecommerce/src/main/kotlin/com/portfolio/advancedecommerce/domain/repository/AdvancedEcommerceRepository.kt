package com.portfolio.advancedecommerce.domain.repository
import com.portfolio.advancedecommerce.domain.model.*
interface AdvancedEcommerceRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}