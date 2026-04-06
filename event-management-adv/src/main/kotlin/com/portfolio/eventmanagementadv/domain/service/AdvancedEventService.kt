package com.portfolio.eventmanagementadv.domain.service

import com.portfolio.eventmanagementadv.domain.model.DetailedEvent
import org.springframework.stereotype.Service

@Service
class AdvancedEventService {
    fun getEventDetails(): DetailedEvent = DetailedEvent("Global Tech Summit", 5000, 4200)
}
