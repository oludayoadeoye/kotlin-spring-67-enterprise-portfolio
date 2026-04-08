package com.portfolio.colorpicker.domain.repository
import com.portfolio.colorpicker.domain.model.*
interface ColorPickerRepository {
    suspend fun findAll(): List<Any>
    suspend fun save(entity: Any): Any
    suspend fun findById(id: Long): Any?
    suspend fun deleteById(id: Long)
}