package com.portfolio.chatappadv.domain.repository
import com.portfolio.chatappadv.domain.model.*
interface ChatAppAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}