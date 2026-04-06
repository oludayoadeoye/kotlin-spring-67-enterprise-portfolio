package com.portfolio.imagerecognition.application.web

import com.portfolio.imagerecognition.domain.service.ImageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/image")
class ImageController(private val service: ImageService) {
    @PostMapping("/recognize") fun recognize(@RequestParam url: String) = service.recognize(url)
}
