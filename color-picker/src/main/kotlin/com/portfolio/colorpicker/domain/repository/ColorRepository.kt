package com.portfolio.colorpicker.domain.repository

import com.portfolio.colorpicker.domain.model.Color

interface ColorRepository {
    suspend fun findAll(): List<Color>
    suspend fun save(color: Color): Color
    suspend fun findById(id: Long): Color?
}
