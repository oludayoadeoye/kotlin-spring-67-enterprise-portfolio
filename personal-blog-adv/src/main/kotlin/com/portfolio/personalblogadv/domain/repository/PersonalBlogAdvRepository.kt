package com.portfolio.personalblogadv.domain.repository
import com.portfolio.personalblogadv.domain.model.*
interface PersonalBlogAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}