package com.portfolio.eventmanagementadv.application.web

import com.portfolio.eventmanagementadv.domain.service.AdvancedEventService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events/adv")
class AdvancedEventController(private val service: AdvancedEventService) {
    @GetMapping("/details") fun details() = service.getEventDetails()
}
