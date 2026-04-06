package com.portfolio.smartinventoryadv.application.web

import com.portfolio.smartinventoryadv.domain.service.AdvancedInventoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/inventory/adv")
class AdvancedInventoryController(private val service: AdvancedInventoryService) {
    @GetMapping("/alerts") fun alerts() = service.getAlerts()
}
