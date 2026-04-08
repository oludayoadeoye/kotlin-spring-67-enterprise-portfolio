package com.portfolio.fitnesstracker.domain.repository
import com.portfolio.fitnesstracker.domain.model.*
interface FitnessTrackerRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}