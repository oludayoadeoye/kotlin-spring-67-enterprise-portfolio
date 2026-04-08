package com.portfolio.realtimelanguagetranslationapp.domain.model

data class Conversation(
    val id: String,
    val sourceLang: String,
    val targetLang: String,
    val active: Boolean = true
)
