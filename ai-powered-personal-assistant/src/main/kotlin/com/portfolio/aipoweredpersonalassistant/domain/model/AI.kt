package com.portfolio.aipoweredpersonalassistant.domain.model

data class AIResponse(
    val query: String,
    val response: String,
    val model: String = "Gemini-1.5-Flash"
)
