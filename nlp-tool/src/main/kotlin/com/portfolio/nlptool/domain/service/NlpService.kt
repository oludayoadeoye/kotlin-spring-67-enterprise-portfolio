package com.portfolio.nlptool.domain.service

import com.portfolio.nlptool.domain.model.Analysis
import com.portfolio.nlptool.domain.repository.NlpRepository
import org.springframework.stereotype.Service

@Service
class NlpService(private val repository: NlpRepository) {
    suspend fun analyze(text: String): Analysis {
        val sentiment = if (text.lowercase().contains("good") || text.lowercase().contains("great")) "Positive" else "Neutral"
        val words = text.split(" ").filter { it.length > 4 }.take(3)
        val analysis = Analysis(text = text, sentiment = sentiment, keywords = words)
        return repository.save(analysis)
    }

    suspend fun getHistory(): List<Analysis> = repository.findAll()
}
