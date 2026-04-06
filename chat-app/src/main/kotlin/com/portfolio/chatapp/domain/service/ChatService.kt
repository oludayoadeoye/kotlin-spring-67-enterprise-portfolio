package com.portfolio.chatapp.domain.service

import com.portfolio.chatapp.domain.model.Message
import org.springframework.stereotype.Service

@Service
class ChatService {
    private val messages = mutableListOf<Message>()

    fun getHistory(): List<Message> = messages
    fun sendMessage(message: Message): Message {
        messages.add(message)
        return message
    }
}
