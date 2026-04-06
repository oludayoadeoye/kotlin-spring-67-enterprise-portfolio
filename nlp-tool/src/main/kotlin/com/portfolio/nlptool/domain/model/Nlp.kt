package com.portfolio.nlptool.domain.model

data class Analysis(
    val sentiment: String,
    val keywords: List<String>,
    val language: String = "English"
)
