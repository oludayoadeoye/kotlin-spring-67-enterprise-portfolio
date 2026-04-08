package com.portfolio.ecommerceplatform.application.web

import com.portfolio.ecommerceplatform.domain.model.Product
import com.portfolio.ecommerceplatform.domain.service.StoreService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/store")
@Tag(name = "Store", description = "Ecommerce endpoints")
class StoreController(private val storeService: StoreService) {
    @GetMapping("/products") suspend fun products() = storeService.getProducts()
    @PostMapping("/order") suspend fun order(@RequestBody items: List<Product>) = storeService.placeOrder(items)
}
