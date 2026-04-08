package com.portfolio.virtualrealitygame.domain.repository
import com.portfolio.virtualrealitygame.domain.model.*
interface VirtualRealityGameRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}