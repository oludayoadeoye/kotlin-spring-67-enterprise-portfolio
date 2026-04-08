package com.portfolio.langlearningapp.domain.service

import com.portfolio.langlearningapp.domain.model.Vocabulary
import com.portfolio.langlearningapp.domain.repository.LangRepository
import org.springframework.stereotype.Service

@Service
class LangService(private val repository: LangRepository) {
    suspend fun getDailyVocab(): List<Vocabulary> = repository.findAll()
    suspend fun addVocab(vocab: Vocabulary): Vocabulary = repository.save(vocab)
    suspend fun getById(id: Long): Vocabulary? = repository.findById(id)
    suspend fun delete(id: Long) = repository.deleteById(id)
}
