package com.portfolio.colorpicker.application.web

import com.portfolio.colorpicker.domain.model.Color
import com.portfolio.colorpicker.domain.service.ColorService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/colors")
@Tag(name = "Color Picker", description = "Color palette endpoints")
class ColorController(private val service: ColorService) {
    @GetMapping suspend fun list() = service.getPopularColors()
    @PostMapping @ResponseStatus(HttpStatus.CREATED) suspend fun add(@RequestBody color: Color) = service.addColor(color)
}
