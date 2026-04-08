package com.portfolio.speechrecognitionsystemadv.domain.repository
import com.portfolio.speechrecognitionsystemadv.domain.model.*
interface SpeechRecognitionSystemAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}