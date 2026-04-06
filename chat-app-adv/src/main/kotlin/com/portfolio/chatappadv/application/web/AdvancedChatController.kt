package com.portfolio.chatappadv.application.web

import com.portfolio.chatappadv.domain.service.AdvancedChatService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/chat/adv")
class AdvancedChatController(private val service: AdvancedChatService) {
    @GetMapping("/groups") fun groups() = service.getGroups()
}
