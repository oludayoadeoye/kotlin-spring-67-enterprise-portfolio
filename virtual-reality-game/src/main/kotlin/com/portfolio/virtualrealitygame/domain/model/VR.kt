package com.portfolio.virtualrealitygame.domain.model

data class GameObject(
    val id: String,
    val type: String,
    val position: List<Double>,
    val scale: Double = 1.0
)
