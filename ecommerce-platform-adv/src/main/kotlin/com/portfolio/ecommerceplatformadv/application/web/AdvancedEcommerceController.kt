package com.portfolio.ecommerceplatformadv.application.web

import com.portfolio.ecommerceplatformadv.domain.service.AdvancedEcommerceService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/store/adv")
class AdvancedEcommerceController(private val service: AdvancedEcommerceService) {
    @GetMapping("/personal") fun personal(@RequestParam id: String) = service.getPersonalized(id)
}
