package com.portfolio.realtimetranslation.domain.repository
import com.portfolio.realtimetranslation.domain.model.*
interface RealTimeTranslationRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}