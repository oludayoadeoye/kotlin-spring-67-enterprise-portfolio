package com.portfolio.taskmanageradv.domain.repository
import com.portfolio.taskmanageradv.domain.model.*
interface TaskManagerAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}