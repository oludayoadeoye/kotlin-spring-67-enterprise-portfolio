package com.portfolio.quizapp.domain.repository

import com.portfolio.quizapp.domain.model.Question

interface QuestionRepository {
    suspend fun findAll(): List<Question>
    suspend fun save(question: Question): Question
    suspend fun findById(id: Long): Question?
    suspend fun deleteById(id: Long)
}
