package com.portfolio.langlearningapp.domain.repository

import com.portfolio.langlearningapp.domain.model.Vocabulary

interface LangRepository {
    suspend fun findAll(): List<Vocabulary>
    suspend fun save(vocab: Vocabulary): Vocabulary
    suspend fun findById(id: Long): Vocabulary?
    suspend fun deleteById(id: Long)
}
