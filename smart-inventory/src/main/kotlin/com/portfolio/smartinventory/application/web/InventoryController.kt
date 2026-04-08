package com.portfolio.smartinventory.application.web

import com.portfolio.smartinventory.domain.model.Item
import com.portfolio.smartinventory.domain.service.InventoryService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/inventory")
@Tag(name = "Inventory", description = "Stock management endpoints")
class InventoryController(private val service: InventoryService) {
    @GetMapping suspend fun list() = service.getItems()
    @PostMapping @ResponseStatus(HttpStatus.CREATED) suspend fun add(@RequestBody item: Item) = service.addItem(item)
    @PatchMapping("/{id}") suspend fun update(@PathVariable id: Long, @RequestParam qty: Int): ResponseEntity<Item> =
        service.updateStock(id, qty)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) suspend fun delete(@PathVariable id: Long) = service.delete(id)
}
