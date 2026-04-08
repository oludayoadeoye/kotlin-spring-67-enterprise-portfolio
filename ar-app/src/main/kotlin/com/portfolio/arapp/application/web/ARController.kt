package com.portfolio.arapp.application.web

import com.portfolio.arapp.domain.model.ARAnchor
import com.portfolio.arapp.domain.service.ARService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ar")
@Tag(name = "AR", description = "Augmented Reality anchor endpoints")
class ARController(private val service: ARService) {
    @GetMapping("/anchors") suspend fun anchors() = service.getAnchors()
    @PostMapping("/anchors") suspend fun add(@RequestBody anchor: ARAnchor) = service.addAnchor(anchor)
}
