package com.portfolio.chatapp.application.web

import com.portfolio.chatapp.domain.model.Message
import com.portfolio.chatapp.domain.service.ChatService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/chat")
@Tag(name = "Chat", description = "Chat messaging endpoints")
class ChatController(private val chatService: ChatService) {
    @GetMapping("/history") suspend fun history() = chatService.getHistory()
    @PostMapping("/send") suspend fun send(@RequestBody message: Message) = chatService.sendMessage(message)
}
