package com.portfolio.smartinventoryadv.application.web

import com.portfolio.smartinventoryadv.domain.model.StockLevel
import com.portfolio.smartinventoryadv.domain.service.AdvancedInventoryService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/inventory/adv")
@Tag(name = "Inventory Adv", description = "Advanced inventory management endpoints")
class AdvancedInventoryController(private val service: AdvancedInventoryService) {
    @GetMapping suspend fun list() = service.getAll()
    @GetMapping("/alerts") suspend fun alerts() = service.getAlerts()
    @PatchMapping("/{sku}") suspend fun update(@PathVariable sku: String, @RequestParam qty: Int): ResponseEntity<StockLevel> =
        service.updateStock(sku, qty)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}
