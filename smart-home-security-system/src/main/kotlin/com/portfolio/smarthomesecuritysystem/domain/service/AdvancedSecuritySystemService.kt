package com.portfolio.smarthomesecuritysystem.domain.service

import com.portfolio.smarthomesecuritysystem.domain.model.SecurityZone
import org.springframework.stereotype.Service

@Service
class AdvancedSecuritySystemService {
    fun getZones(): List<SecurityZone> = listOf(
        SecurityZone("front_door", "Secure", 0.8),
        SecurityZone("back_yard", "Secure", 0.5)
    )
}
