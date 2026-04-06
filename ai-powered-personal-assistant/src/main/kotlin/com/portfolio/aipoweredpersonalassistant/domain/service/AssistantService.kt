package com.portfolio.aipoweredpersonalassistant.domain.service

import com.portfolio.aipoweredpersonalassistant.domain.model.AIResponse
import org.springframework.stereotype.Service

@Service
class AssistantService {
    fun chat(query: String): AIResponse {
        val reply = when {
            query.contains("weather") -> "Checking weather for you..."
            query.contains("time") -> "The current time is..."
            else -> "I'm your personal AI assistant. How can I help?"
        }
        return AIResponse(query, reply)
    }
}
