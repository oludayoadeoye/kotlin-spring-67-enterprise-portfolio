package com.portfolio.eventmanagementadv.domain.model

data class Ticket(
    val id: String,
    val type: String, // "VIP", "Standard"
    val price: Double
)

data class DetailedEvent(
    val name: String,
    val capacity: Int,
    val soldTickets: Int
)
