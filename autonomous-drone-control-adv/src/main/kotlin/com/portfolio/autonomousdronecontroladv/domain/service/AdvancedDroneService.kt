package com.portfolio.autonomousdronecontroladv.domain.service

import com.portfolio.autonomousdronecontroladv.domain.model.FlightPath
import org.springframework.stereotype.Service

@Service
class AdvancedDroneService {
    fun getPath(): FlightPath = FlightPath(listOf("Base", "Point A", "Point B"), "14:30")
}
