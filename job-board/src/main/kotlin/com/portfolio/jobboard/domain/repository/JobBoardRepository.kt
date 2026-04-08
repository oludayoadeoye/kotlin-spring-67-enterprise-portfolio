package com.portfolio.jobboard.domain.repository
import com.portfolio.jobboard.domain.model.*
interface JobBoardRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}