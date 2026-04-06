package com.portfolio.homeautomation.domain.model

data class Device(
    val id: Long? = null,
    val name: String,
    val type: String,
    val status: String = "Off"
)
