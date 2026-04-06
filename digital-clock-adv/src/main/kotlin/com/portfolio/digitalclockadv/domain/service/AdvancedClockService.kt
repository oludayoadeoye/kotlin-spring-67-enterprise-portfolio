package com.portfolio.digitalclockadv.domain.service

import com.portfolio.digitalclockadv.domain.model.WorldTime
import org.springframework.stereotype.Service
import java.time.ZonedDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Service
class AdvancedClockService {
    fun getWorldTime(city: String, zoneId: String): WorldTime {
        val now = ZonedDateTime.now(ZoneId.of(zoneId))
        return WorldTime(city, now.format(DateTimeFormatter.ofPattern("HH:mm:ss")), now.offset.toString())
    }
}
