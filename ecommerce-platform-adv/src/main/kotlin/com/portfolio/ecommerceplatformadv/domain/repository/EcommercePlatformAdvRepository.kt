package com.portfolio.ecommerceplatformadv.domain.repository
import com.portfolio.ecommerceplatformadv.domain.model.*
interface EcommercePlatformAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}