package com.portfolio.colorpicker.domain.service

import com.portfolio.colorpicker.domain.model.Color
import com.portfolio.colorpicker.domain.repository.ColorRepository
import org.springframework.stereotype.Service

@Service
class ColorService(private val repository: ColorRepository) {
    suspend fun getPopularColors(): List<Color> = repository.findAll()
    suspend fun addColor(color: Color): Color = repository.save(color)
}
