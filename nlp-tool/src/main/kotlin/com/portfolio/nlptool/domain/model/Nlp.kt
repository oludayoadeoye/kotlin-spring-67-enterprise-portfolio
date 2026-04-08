package com.portfolio.nlptool.domain.model

import java.time.LocalDateTime

data class Analysis(
    val id: Long? = null,
    val text: String,
    val sentiment: String,
    val keywords: List<String>,
    val language: String = "English",
    val createdAt: LocalDateTime = LocalDateTime.now()
)
