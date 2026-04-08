package com.portfolio.realtimelanguagetranslationapp.domain.repository
import com.portfolio.realtimelanguagetranslationapp.domain.model.*
interface RealTimeLanguageTranslationAppRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}