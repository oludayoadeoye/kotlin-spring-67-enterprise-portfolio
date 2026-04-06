package com.portfolio.realtimetranslation.domain.service

import com.portfolio.realtimetranslation.domain.model.Translation
import org.springframework.stereotype.Service

@Service
class TranslationService {
    fun translate(text: String, from: String, to: String): Translation {
        // Deep Logic Mock: Simulate translation
        val translated = "Translated($text) to $to"
        return Translation(text, translated, from, to)
    }
}
