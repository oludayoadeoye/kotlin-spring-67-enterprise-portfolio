package com.portfolio.langlearningapp.domain.service

import com.portfolio.langlearningapp.domain.model.Vocabulary
import org.springframework.stereotype.Service

@Service
class LangService {
    fun getDailyVocab(): List<Vocabulary> = listOf(
        Vocabulary("Haus", "House", "A1"),
        Vocabulary("Garten", "Garden", "A1")
    )
}
