package com.portfolio.speechrecognitionsystem.domain.repository
import com.portfolio.speechrecognitionsystem.domain.model.*
interface SpeechRecognitionSystemRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}