package com.portfolio.aipoweredpersonalassistant.application.web

import com.portfolio.aipoweredpersonalassistant.domain.service.AssistantService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/assistant")
class AssistantController(private val service: AssistantService) {
    @PostMapping("/chat") fun chat(@RequestBody query: String) = service.chat(query)
}
