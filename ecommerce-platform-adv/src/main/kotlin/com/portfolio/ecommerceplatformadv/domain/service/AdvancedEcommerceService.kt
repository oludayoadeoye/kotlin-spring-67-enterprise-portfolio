package com.portfolio.ecommerceplatformadv.domain.service

import com.portfolio.ecommerceplatformadv.domain.model.Recommendation
import org.springframework.stereotype.Service

@Service
class AdvancedEcommerceService {
    fun getPersonalized(userId: String): Recommendation = Recommendation(userId, listOf("High-end Laptop", "Noise Cancelling Headphones"))
}
