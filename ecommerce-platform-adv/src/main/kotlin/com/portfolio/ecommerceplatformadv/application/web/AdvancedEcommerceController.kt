package com.portfolio.ecommerceplatformadv.application.web

import com.portfolio.ecommerceplatformadv.domain.model.CartItem
import com.portfolio.ecommerceplatformadv.domain.service.AdvancedEcommerceService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/store/adv")
@Tag(name = "Ecommerce Adv", description = "Advanced shopping cart endpoints")
class AdvancedEcommerceController(private val service: AdvancedEcommerceService) {
    @GetMapping("/cart/{userId}") suspend fun getCart(@PathVariable userId: String) = service.getCart(userId)
    @PostMapping("/cart") suspend fun add(@RequestBody item: CartItem) = service.addItem(item)
    @DeleteMapping("/cart/{userId}") suspend fun clear(@PathVariable userId: String) = service.clearCart(userId)
}
