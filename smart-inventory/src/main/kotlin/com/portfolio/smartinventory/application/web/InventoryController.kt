package com.portfolio.smartinventory.application.web

import com.portfolio.smartinventory.domain.model.Item
import com.portfolio.smartinventory.domain.service.InventoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/inventory")
class InventoryController(private val service: InventoryService) {
    @GetMapping fun list() = service.getItems()
    @PostMapping fun add(@RequestBody item: Item) = service.addItem(item)
    @PatchMapping("/{id}") fun update(@PathVariable id: Long, @RequestParam qty: Int) = service.updateStock(id, qty)
}
