package com.portfolio.customoperatingsystem.domain.model

data class Process(
    val id: Int,
    val name: String,
    val state: String = "Ready",
    val cpuTime: Long = 0
)
