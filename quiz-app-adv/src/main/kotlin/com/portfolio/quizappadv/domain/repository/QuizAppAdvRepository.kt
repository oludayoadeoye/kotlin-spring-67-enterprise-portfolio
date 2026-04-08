package com.portfolio.quizappadv.domain.repository
import com.portfolio.quizappadv.domain.model.*
interface QuizAppAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}