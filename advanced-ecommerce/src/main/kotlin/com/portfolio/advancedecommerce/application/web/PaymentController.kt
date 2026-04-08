package com.portfolio.advancedecommerce.application.web

import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PaymentService {
    fun createCheckoutSession(orderId: Long): String {
        // Implementation for Lemon Squeezy API
        // Returns a checkout URL for the user
        return "https://checkout.lemonsqueezy.com/checkout/buy/...&custom[order_id]=$orderId"
    }
}

@RestController
@RequestMapping("/api/payments")
class PaymentController(private val paymentService: PaymentService) {
    
    @PostMapping("/checkout/{orderId}")
    fun checkout(@PathVariable orderId: Long): ResponseEntity<Map<String, String>> {
        val url = paymentService.createCheckoutSession(orderId)
        return ResponseEntity.ok(mapOf("checkoutUrl" to url))
    }

    @PostMapping("/webhook")
    fun handleWebhook(@RequestBody payload: String, @RequestHeader("X-Signature") signature: String): ResponseEntity<String> {
        // Verify signature and fulfill order
        println("Received Lemon Squeezy Webhook: $payload")
        return ResponseEntity.ok("Webhook Processed")
    }
}
