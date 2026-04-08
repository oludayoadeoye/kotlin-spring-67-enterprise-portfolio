package com.portfolio.chatapp.domain.repository

import com.portfolio.chatapp.domain.model.Message

interface ChatRepository {
    suspend fun findAll(): List<Message>
    suspend fun save(message: Message): Message
}
