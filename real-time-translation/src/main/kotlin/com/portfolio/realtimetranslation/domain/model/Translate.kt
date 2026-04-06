package com.portfolio.realtimetranslation.domain.model

data class Translation(
    val sourceText: String,
    val targetText: String,
    val sourceLang: String,
    val targetLang: String
)
