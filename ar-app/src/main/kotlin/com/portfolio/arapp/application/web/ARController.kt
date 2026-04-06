package com.portfolio.arapp.application.web

import com.portfolio.arapp.domain.service.ARService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ar")
class ARController(private val service: ARService) {
    @GetMapping("/anchors") fun anchors() = service.getAnchors()
}
