package com.portfolio.colorpicker.application.web

import com.portfolio.colorpicker.domain.service.ColorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/colors")
class ColorController(private val service: ColorService) {
    @GetMapping fun list() = service.getPopularColors()
}
