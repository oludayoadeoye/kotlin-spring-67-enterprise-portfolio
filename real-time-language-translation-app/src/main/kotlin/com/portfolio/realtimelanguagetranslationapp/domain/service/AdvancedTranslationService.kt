package com.portfolio.realtimelanguagetranslationapp.domain.service

import com.portfolio.realtimelanguagetranslationapp.domain.model.Conversation
import org.springframework.stereotype.Service

@Service
class AdvancedTranslationService {
    fun startSession(): Conversation = Conversation("sess_123", "en", "es")
}
