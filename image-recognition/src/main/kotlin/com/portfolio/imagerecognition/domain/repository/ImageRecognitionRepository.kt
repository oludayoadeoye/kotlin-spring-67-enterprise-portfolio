package com.portfolio.imagerecognition.domain.repository
import com.portfolio.imagerecognition.domain.model.*
interface ImageRecognitionRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}