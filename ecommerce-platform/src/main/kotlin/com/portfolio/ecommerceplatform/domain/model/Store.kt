package com.portfolio.ecommerceplatform.domain.model

data class Product(
    val id: Long? = null,
    val name: String,
    val price: Double,
    val stock: Int
)

data class Order(
    val id: Long? = null,
    val total: Double,
    val status: String = "PROCESSING"
)
