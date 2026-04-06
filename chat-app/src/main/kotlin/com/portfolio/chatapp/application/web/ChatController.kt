package com.portfolio.chatapp.application.web

import com.portfolio.chatapp.domain.model.Message
import com.portfolio.chatapp.domain.service.ChatService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/chat")
class ChatController(private val chatService: ChatService) {
    @GetMapping("/history") fun history() = chatService.getHistory()
    @PostMapping("/send") fun send(@RequestBody message: Message) = chatService.sendMessage(message)
}
