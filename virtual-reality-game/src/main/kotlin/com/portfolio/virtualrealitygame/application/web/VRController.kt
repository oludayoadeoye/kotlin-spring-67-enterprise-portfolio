package com.portfolio.virtualrealitygame.application.web

import com.portfolio.virtualrealitygame.domain.service.VRService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vr")
class VRController(private val service: VRService) {
    @GetMapping("/scene") fun scene() = service.getScene()
}
