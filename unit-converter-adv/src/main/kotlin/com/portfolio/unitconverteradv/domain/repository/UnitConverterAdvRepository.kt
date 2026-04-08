package com.portfolio.unitconverteradv.domain.repository
import com.portfolio.unitconverteradv.domain.model.*
interface UnitConverterAdvRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}