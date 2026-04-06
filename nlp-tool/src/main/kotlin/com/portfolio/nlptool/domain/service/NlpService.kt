package com.portfolio.nlptool.domain.service

import com.portfolio.nlptool.domain.model.Analysis
import org.springframework.stereotype.Service

@Service
class NlpService {
    fun analyze(text: String): Analysis {
        val sentiment = if (text.contains("good") || text.contains("great")) "Positive" else "Neutral"
        val words = text.split(" ").filter { it.length > 4 }.take(3)
        return Analysis(sentiment, words)
    }
}
