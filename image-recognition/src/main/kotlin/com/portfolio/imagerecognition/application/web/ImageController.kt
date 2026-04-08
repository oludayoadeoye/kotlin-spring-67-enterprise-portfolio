package com.portfolio.imagerecognition.application.web

import com.portfolio.imagerecognition.domain.service.ImageService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/image")
@Tag(name = "Image Recognition", description = "Visual analysis endpoints")
class ImageController(private val service: ImageService) {
    @PostMapping("/recognize") suspend fun recognize(@RequestParam url: String) = service.recognize(url)
    @GetMapping("/history") suspend fun history() = service.getHistory()
}
