package com.portfolio.chatappadv.domain.service

import com.portfolio.chatappadv.domain.model.Group
import org.springframework.stereotype.Service

@Service
class AdvancedChatService {
    fun getGroups(): List<Group> = listOf(Group("1", "DevTeam", listOf("Alice", "Bob")))
}
