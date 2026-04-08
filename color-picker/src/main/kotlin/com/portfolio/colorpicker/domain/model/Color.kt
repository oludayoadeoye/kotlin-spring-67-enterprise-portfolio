package com.portfolio.colorpicker.domain.model

data class Color(
    val id: Long? = null,
    val name: String,
    val hex: String,
    val r: Int,
    val g: Int,
    val b: Int
)
