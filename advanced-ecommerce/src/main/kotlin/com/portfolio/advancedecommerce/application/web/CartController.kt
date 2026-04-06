package com.portfolio.advancedecommerce.application.web

import com.portfolio.advancedecommerce.domain.model.CartItem
import com.portfolio.advancedecommerce.domain.service.CartService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cart")
class CartController(private val service: CartService) {
    @GetMapping("/{userId}") fun get(@PathVariable userId: String) = service.getCart(userId)
    @PostMapping("/{userId}/add") fun add(@PathVariable userId: String, @RequestBody item: CartItem) = service.addItem(userId, item)
}
