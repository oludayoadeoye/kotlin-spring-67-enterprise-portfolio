package com.portfolio.ecommerceplatform.application.web

import com.portfolio.ecommerceplatform.domain.model.Product
import com.portfolio.ecommerceplatform.domain.model.Order
import com.portfolio.ecommerceplatform.domain.service.StoreService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/store")
class StoreController(private val storeService: StoreService) {
    @GetMapping("/products") fun products() = storeService.getProducts()
    @PostMapping("/order") fun order(@RequestBody items: List<Product>) = storeService.placeOrder(items)
}
