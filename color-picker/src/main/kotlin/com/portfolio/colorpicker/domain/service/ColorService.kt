package com.portfolio.colorpicker.domain.service

import com.portfolio.colorpicker.domain.model.Color
import org.springframework.stereotype.Service

@Service
class ColorService {
    fun getPopularColors(): List<Color> = listOf(
        Color("Red", "#FF0000", 255, 0, 0),
        Color("Green", "#00FF00", 0, 255, 0),
        Color("Blue", "#0000FF", 0, 0, 255)
    )
}
