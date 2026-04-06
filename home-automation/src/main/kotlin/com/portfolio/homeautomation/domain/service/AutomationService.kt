package com.portfolio.homeautomation.domain.service

import com.portfolio.homeautomation.domain.model.Device
import org.springframework.stereotype.Service

@Service
class AutomationService {
    private val devices = mutableListOf(
        Device(1, "Living Room Light", "Light"),
        Device(2, "Kitchen AC", "AC")
    )

    fun getDevices(): List<Device> = devices
    fun toggleDevice(id: Long): Device? {
        val index = devices.indexOfFirst { it.id == id }
        if (index == -1) return null
        val updated = devices[index].copy(status = if (devices[index].status == "Off") "On" else "Off")
        devices[index] = updated
        return updated
    }
}
