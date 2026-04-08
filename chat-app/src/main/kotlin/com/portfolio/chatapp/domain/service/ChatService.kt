package com.portfolio.chatapp.domain.service

import com.portfolio.chatapp.domain.model.Message
import com.portfolio.chatapp.domain.repository.ChatRepository
import org.springframework.stereotype.Service

@Service
class ChatService(private val repository: ChatRepository) {
    suspend fun getHistory(): List<Message> = repository.findAll()
    suspend fun sendMessage(message: Message): Message = repository.save(message)
}
