package com.portfolio.ecommerceplatformadv.domain.model

data class Recommendation(
    val userId: String,
    val products: List<String>
)
