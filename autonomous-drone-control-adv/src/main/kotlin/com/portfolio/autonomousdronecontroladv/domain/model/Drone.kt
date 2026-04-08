package com.portfolio.autonomousdronecontroladv.domain.model

data class FlightPath(
    val waypoints: List<String>,
    val estimatedArrival: String
)
